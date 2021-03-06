package pl.coderslab.warsztaty3.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private int userGroupId;

	public User() {
	}

	public User(int id, String username, String email, String password, int userGroupId) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.setPassword(password);
		this.userGroupId = userGroupId;
	}

	public User(String username, String email, String password, int userGroupId) {
		this.username = username;
		this.email = email;
		this.setPassword(password);
		this.userGroupId = userGroupId;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", userGroupId=" + userGroupId + "]";
	}

}
