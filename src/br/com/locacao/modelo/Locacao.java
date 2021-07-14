package br.com.locacao.modelo;

import java.time.LocalDateTime;

public class Locacao {
	private Integer id;
	private Cliente cliente;
	private Bicicleta bicicleta;
	
	private LocalDateTime horaDaLocacao;
	private LocalDateTime devolucacao;
	private Situacao situacao;
	
	public Locacao() {
		
	}
	public Locacao(Cliente cliente, Bicicleta bicicleta, Situacao situacao) {
		this.cliente = cliente;
		this.bicicleta = bicicleta;
		this.horaDaLocacao = LocalDateTime.now();
		this.devolucacao = LocalDateTime.now().minusHours(8);
		this.situacao = situacao;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
	public LocalDateTime getHoraDaLocacao() {
		return horaDaLocacao;
	}
	public void setHoraDaLocacao(LocalDateTime horaDaLocacao) {
		this.horaDaLocacao = horaDaLocacao;
	}
	public LocalDateTime getDevolucacao() {
		return devolucacao;
	}
	public void setDevolucacao(LocalDateTime devolucacao) {
		this.devolucacao = devolucacao;
	}
	
	
}
