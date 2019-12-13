package com.duongminhtai.model.bean;

public class NhanVien {
	private String id;
	private String name;
	private String address;
	private String birthday;
	private String phone;
	private PhongBan phongBan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public NhanVien(String id, String name, String address, String birthday, String phone, PhongBan phongBan) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.phone = phone;
		this.phongBan = phongBan;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", name=" + name + ", address=" + address + ", birthday=" + birthday + ", phone="
				+ phone + ", phongBan=" + phongBan + "]";
	}
}
