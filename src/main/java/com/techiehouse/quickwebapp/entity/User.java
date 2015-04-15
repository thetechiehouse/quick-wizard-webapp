package com.techiehouse.quickwebapp.entity;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;

@XmlRootElement
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String seqId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSeqId() {
		return seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}

}
