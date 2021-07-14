package br.com.locacao.modelo;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String email;
	private String senha;
	private String cpf;
	private List<String> numeroContato;
	
	public Cliente() {
		
	}
	public Cliente(Integer id) {
		this.id = id;
	}
	public Cliente(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<String> getNumeroContato() {
		return numeroContato;
	}
	public void setNumeroContato(List<String> numeroContato) {
		this.numeroContato = numeroContato;
	}
}
