package com.song.kyung.Vo;

import java.util.Date;

public class HelloMessage {
	
	private String name;
	private String contents;
	private Date send_date;
	private String channel_type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public String getChannel_type() {
		return channel_type;
	}
	public void setChannel_type(String channel_type) {
		this.channel_type = channel_type;
	}
	public HelloMessage(String name, String contents, Date send_date, String channel_type) {
		super();
		this.name = name;
		this.contents = contents;
		this.send_date = send_date;
		this.channel_type = channel_type;
	}
	public HelloMessage() {
		super();
	}
	
	
	
	

}
