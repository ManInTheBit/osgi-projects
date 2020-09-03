package org.burakisik.osgi.data.manager.dao.dto;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.burakisik.osgi.annotations.Password;
import org.burakisik.osgi.annotations.Username;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

	@Username
	private String username;
	
	@Password
	private String password;
}
