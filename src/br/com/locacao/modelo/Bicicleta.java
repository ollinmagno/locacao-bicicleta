package br.com.locacao.modelo;

public class Bicicleta {

	private Integer id;
	private String cor;
	private int marchas;
	private boolean disponivel;
	private boolean desativada;
	private int aro;
	private Modelo modelo;

	public Bicicleta() {

	}

	public Bicicleta(Modelo modelo) {
		this.modelo = modelo;
	}

	public Bicicleta(String cor, int marchas, boolean disponivel, boolean desativada, int aro, Modelo modelo) {
		this.cor = cor;
		this.marchas = marchas;
		this.disponivel = disponivel;
		this.desativada = desativada;
		this.aro = aro;
		this.modelo = modelo;
	}

	public boolean isDesativada() {
		return desativada;
	}

	public void setDesativada(boolean desativada) {
		this.desativada = desativada;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
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

	@Override
	public String toString() {
		return "Bicicleta [id=" + id + ", cor=" + cor + ", marchas=" + marchas + ", aro=" + aro + ", modelo="
				+ modelo.getMarca() + ", Preço por hora=" + modelo.getPrecoPorHora() + "]";
	}

}
