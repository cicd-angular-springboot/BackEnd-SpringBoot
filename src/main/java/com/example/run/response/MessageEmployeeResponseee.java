package com.example.run.response;

public class MessageEmployeeResponseee {
	private String message;
	private Long id;

	public MessageEmployeeResponseee() {
		super();
	}

	public MessageEmployeeResponseee(String message, Long id) {
		super();
		this.message = message;
		this.id = id;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
