package com.song.kyung.Vo;

public class Notice {
	
	private int id;
	private String subject;
	private String content;
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	private String author;
	private int read_count;
	private String reg_date;
	private String upt_date;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getRead_count() {
		return read_count;
	}


	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


	public String getUpt_date() {
		return upt_date;
	}


	public void setUpt_date(String upt_date) {
		this.upt_date = upt_date;
	}

	



	public Notice(int id, String subject, String content, String author, int read_count, String reg_date,
			String upt_date) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.author = author;
		this.read_count = read_count;
		this.reg_date = reg_date;
		this.upt_date = upt_date;
	}


	public Notice() {
		super();
	}
	
	
	
	
}
