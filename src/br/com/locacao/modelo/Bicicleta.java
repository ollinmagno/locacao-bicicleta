package br.com.locacao.modelo;

public class Bicicleta {

	private Integer id;
	private String cor;
	private int marchas;
	private int aro;
	private Modelo modelo;
	
	public Bicicleta() {
		
	}
	public Bicicleta(Integer id, int aro, String cor, int marchas, Modelo modelo) {
		this.id = id;
		this.cor = cor;
		this.marchas = marchas;
		this.aro = aro;
		this.modelo = modelo;
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
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}
