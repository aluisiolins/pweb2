package com.forum.beans;

public class Usuario {
	
	private Integer cod;
	private String nome;
	private String email;
	private String senha;
	
	
	
	public Usuario() {
		super();
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [cod=" + cod + ", nome=" + nome + ", email=" + email +
				", senha=" + senha + "]";
	}
	
	

}
