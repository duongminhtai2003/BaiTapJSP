package com.duongminhtai.model.bean;

public class Quyen {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quyen(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Quyen() {
		super();
	}

	@Override
	public String toString() {
		return "Quyen [id=" + id + ", name=" + name + "]";
	}
}
