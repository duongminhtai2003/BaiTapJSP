package com.duongminhtai.model.bean;

public class NguoiDung {
	private String id;
	private String fullname;
	private String username;
	private String password;
	private Quyen role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Quyen getRole() {
		return role;
	}

	public void setRole(Quyen role) {
		this.role = role;
	}

	public NguoiDung(String id, String fullname, String username, String password, Quyen role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public NguoiDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}

}
