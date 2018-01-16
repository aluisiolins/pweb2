package com.forum.beans;

import java.util.ArrayList;
import java.util.List;

public class Postagem {
	private Integer id;
	private String texto1p;
	private Integer fkref;
	private Integer fkcod;
		
	List<Comentario> listComent= new ArrayList<Comentario>();
		
	
	public Postagem() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexto1p() {
		return texto1p;
	}
	public void setTexto1p(String texto1p) {
		this.texto1p = texto1p;
	}
	public Integer getFkref() {
		return fkref;
	}
	public void setFkref(Integer fkref) {
		this.fkref = fkref;
	}
	public Integer getFkcod() {
		return fkcod;
	}
	public void setFkcod(Integer fkcod) {
		this.fkcod = fkcod;
	}
	
	public void adicionarComentario(Comentario comen){
		listComent.add(comen);
	}
	
	@Override
	public String toString() {
		return "Post[id=" + id + ", texto1p=" + texto1p + ", fkref=" + fkref +
				", fkcod=" + fkcod + "]";
	}
	

	
	
}
