package br.com.locacao.modelo;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String email;
	private String nome;
	private String senha;
	private String cpf;
	private List<String> numeroContato;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String email, String senha) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
