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
import org.burakisik.osgi.data.manager.dao.dto.UserDTO;
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

	private UserDTO mapRecordToUserDTO(ResultSet rs) throws SQLException {
		UserDTO user = UserDTO.builder().id(rs.getLong(USER_TABLE_ID_COLUMN))
				.username(rs.getString(USER_TABLE_USER_NAME_COLUMN))
				.password(rs.getString(USER_TABLE_PASSWORD_COLUMN)).build();
		return user;
	}

	@Override
	public void save(UserDTO user) {
		transactionControl.required(() -> {
			PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			return null;
		});
	}

	@Override
	public void update(UserDTO user) {
		transactionControl.required(() -> {
			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER_BY_PK);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getId());
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
	public List<UserDTO> getAllUser() {
		return transactionControl.notSupported(() -> {

			List<UserDTO> userList = new ArrayList<>();

			PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserDTO user = mapRecordToUserDTO(rs);
				userList.add(user);
			}

			return userList;
		});
	}

	@Override
	public UserDTO getByPK(Long id) {
		return null;
	}

}
