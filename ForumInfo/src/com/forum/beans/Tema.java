package com.forum.beans;

public class Tema {
	private Integer ref;
	private String descricao;
	
	public Tema() {
		super();
	}

	public Integer getRef() {
		return ref;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Tema [ref=" + ref + ", descricao=" + descricao + "]";
	}
	
	

}
