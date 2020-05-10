package com.song.kyung.Vo;

public class Message {
	private int msg_id;
	private String user_id;
	private String send_user_id;
	private String message;
	private String reg_date;
	
	public int getMsg_id() {
		return msg_id;
	}


	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getSend_user_id() {
		return send_user_id;
	}


	public void setSend_user_id(String send_user_id) {
		this.send_user_id = send_user_id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public Message(int msg_id, String user_id, String send_user_id, String message, String reg_date) {
		super();
		this.msg_id = msg_id;
		this.user_id = user_id;
		this.send_user_id = send_user_id;
		this.message = message;
		this.reg_date = reg_date;
	}
	
	


	public Message() {
		super();
	}

	
	
	

}
