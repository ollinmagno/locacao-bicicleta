package br.com.locacao.modelo;

public class Situacao {
	private int id;
	private String status;
	
	public Situacao() {
		
	}
	public Situacao(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
