package com.rest.webservice.restfulwebservice.versioning;

public class PersonV1 {
	private String name;

	public PersonV1() {
		super();

	}

	public PersonV1(String name) {
		super();
		this.name = name;

	}

	@Override
	public String toString() {
		return "Name [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
