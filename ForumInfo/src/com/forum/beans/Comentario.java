package com.forum.beans;

public class Comentario {
	private Integer nr;
	private String texto2c;
	private Integer autor;
	//private Usuario autor;
	private String data;
	private Integer fkidPost;
	
	public Comentario() {
		super();
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public String getTexto2c() {
		return texto2c;
	}

	public void setTexto2c(String texto2c) {
		this.texto2c = texto2c;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getFkidPost() {
		return fkidPost;
	}

	public void setFkidPost(Integer fkidPost) {
		this.fkidPost = fkidPost;
	}

	@Override
	public String toString() {
		return "Comen[nr=" + nr + ", texto2c=" + texto2c + ", autor=" +
				autor + ", data=" + data + ", fkidPost=" + fkidPost + "]";
	}
	
	
	

}
