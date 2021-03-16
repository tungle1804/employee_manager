package poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Users")
public class User {
	@Id
	private String username;
	@Column(name="pass")
	private String pass;
	@Column(name="fullname")
	private String fullname;
	@Column(name="role")
	private boolean role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public boolean getRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
}
