package br.com.locacao.modelo;

public class Modelo {
	
	private Integer id;
	private double precoPorHora;
	private String marca;
	
	public Modelo() {
		
	}
	
	public Modelo(Integer id, double precoPorHora, String marca) {
		this.id = id;
		this.precoPorHora = precoPorHora;
		this.marca = marca;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPrecoPorHora() {
		return precoPorHora;
	}
	public void setPrecoPorHora(double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
