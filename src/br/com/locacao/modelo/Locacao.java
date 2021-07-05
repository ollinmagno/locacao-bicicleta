package br.com.locacao.modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Locacao {
	
	private Integer id;
	private Cliente cliente;
	private List<Bicicleta> bicicletas;
	private Date dataDaLocacao;
	private LocalDateTime horaDaLocacao;
	private LocalDateTime devolucacao;
	private double valorTotal;
	
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
	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}
	public Date getDataDaLocacao() {
		return dataDaLocacao;
	}
	public void setDataDaLocacao(Date dataDaLocacao) {
		this.dataDaLocacao = dataDaLocacao;
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
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
