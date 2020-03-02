package org.burakisik.osgi.data.manager.dao.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
}
