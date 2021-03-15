package com.rest.webservice.restfulwebservice.versioning;

public class PersonV2 {

	
	private Name name;

	public PersonV2() {
		super();
		
	}
	public PersonV2(Name name) {
		super();

		this.name = name;
	}

	@Override
	public String toString() {
		return "Name [ Name=" + name + "]";
	}

	public Name getName() {
		return name;
	}

	public void setLastName(Name name) {
		this.name = name;
	
}
}