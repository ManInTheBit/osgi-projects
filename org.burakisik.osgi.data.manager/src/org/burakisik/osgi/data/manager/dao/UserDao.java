package org.burakisik.osgi.data.manager.dao;

import java.util.List;

import org.burakisik.osgi.data.manager.dao.dto.User;

public interface UserDao {
	
	public User getByPK(Long id);
	
	public List<User> getAllUser();

	public void save(User user);
	
	public void update(User user);
	
	public void deleteById(long id);
}
