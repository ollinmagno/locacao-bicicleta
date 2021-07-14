package br.com.locacao.modelo;

public class Bicicleta {

	private Integer id;
	private String cor;
	private int marchas;
	private int aro;
	
	public Bicicleta() {
		
	}
	public Bicicleta(Integer id) {
		this.id = id;
	}
	public Bicicleta(Integer id, int aro, String cor, int marchas) {
		this.id = id;
		this.cor = cor;
		this.marchas = marchas;
		this.aro = aro;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getMarchas() {
		return marchas;
	}
	public void setMarchas(int marchas) {
		this.marchas = marchas;
	}
	public int getAro() {
		return aro;
	}
	public void setAro(int aro) {
		this.aro = aro;
	}
	
}
