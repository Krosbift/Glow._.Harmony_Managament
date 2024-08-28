package imc.api.routes.users.models;

import imc.api.routes.users.interfaces.UsersInterface;

public class UsersModel implements UsersInterface {
	
	private Long idUser;
	private String names;
	private String surnames;
	private String email;
	private String password;
	private String idUserRol;
	private boolean active;

	public Long getId() {
		return idUser;
	}

	public void setId(Long idUser) {
		this.idUser = idUser;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdUserRol() {
		return idUserRol;
	}

	public void setIdUserRol(String idUserRol) {
		this.idUserRol = idUserRol;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
