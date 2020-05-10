package com.song.kyung.Vo;

public class AuthNumber {
	
	private String id;
	private String email;
	private String random;
	private String regDate;
	private String modDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public AuthNumber(String id, String email, String random, String regDate, String modDate) {
		super();
		this.id = id;
		this.email = email;
		this.random = random;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	public AuthNumber() {
		super();
	}
	
	

}
