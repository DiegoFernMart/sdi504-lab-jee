package com.uniovi.sdi;

import java.util.Date;

public class Comentario {

	private String author;
	private Date date;
	private String message;
	
	public Comentario(String author, Date date, String message) {
		super();
		this.author = author;
		this.date = date;
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
