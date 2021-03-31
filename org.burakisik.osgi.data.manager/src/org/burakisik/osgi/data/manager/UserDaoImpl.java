package org.burakisik.osgi.data.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.burakisik.osgi.data.manager.Constant.*;

import org.burakisik.osgi.data.manager.dao.UserDao;
import org.burakisik.osgi.data.manager.dao.dto.User;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.osgi.service.transaction.control.TransactionControl;
import org.osgi.service.transaction.control.jdbc.JDBCConnectionProvider;

@Component
public class UserDaoImpl implements UserDao {

	@Reference
	TransactionControl transactionControl;

	@Reference(name = "provider")
	JDBCConnectionProvider jdbcConnectionProvider;

	Connection connection;

	@Activate
	protected void activate(Map<String, Object> props) {

		connection = jdbcConnectionProvider.getResource(transactionControl);
		transactionControl.supports(() -> connection.prepareStatement(SQL_QUERY).execute());

	}

	private User mapRecordToUserDTO(ResultSet rs) throws SQLException {
		User user = new User(rs.getLong(USER_TABLE_ID_COLUMN), rs.getString(USER_TABLE_USER_NAME_COLUMN),rs.getString(USER_TABLE_PASSWORD_COLUMN));
		return user;
	}

	@Override
	public void save(User user) {
		transactionControl.required(() -> {
			PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER);
			ps.setString(1, user.username());
			ps.setString(2, user.password());
			ps.executeUpdate();
			return null;
		});
	}

	@Override
	public void update(User user) {
		transactionControl.required(() -> {
			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER_BY_PK);
			ps.setString(1, user.username());
			ps.setString(2, user.password());
			ps.setLong(3, user.id());
			ps.executeUpdate();
			return null;
		});
	}

	@Override
	public void deleteById(long id) {
		transactionControl.required(() -> {
			PreparedStatement pst = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
			pst.setLong(1, id);
			pst.executeUpdate();
			return null;
		});

	}

	@Override
	public List<User> getAllUser() {
		return transactionControl.notSupported(() -> {

			List<User> userList = new ArrayList<>();

			PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = mapRecordToUserDTO(rs);
				userList.add(user);
			}

			return userList;
		});
	}

	@Override
	public User getByPK(Long id) {
		return null;
	}

}
