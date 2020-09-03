package org.burakisik.osgi.data.manager.dao;

import java.util.List;

import org.burakisik.osgi.data.manager.dao.dto.UserDTO;

public interface UserDao {
	
	public UserDTO getByPK(Long id);
	
	public List<UserDTO> getAllUser();

	public void save(UserDTO user);
	
	public void update(UserDTO user);
	
	public void deleteById(long id);
}
