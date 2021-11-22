package br.com.locacao.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;

import br.com.locacao.dao.BicicletaDAO;
import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.relatorio.GerarRelatorio;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class BicicletaBean {
	private Bicicleta bicicleta = new Bicicleta();
	private BicicletaDAO daoBicicleta = new BicicletaDAO();
	private String corSelecionada;
	private List<String> listaCores;
	
	public BicicletaBean() {
		listaCores = daoBicicleta.listaTodasCores();
	}
	
	public List<String> getListaCores() {
		return listaCores;
	}

	public void setListaCores(List<String> listaCores) {
		this.listaCores = listaCores;
	}

	public void emitirRelatorioAction() throws SQLException, ServletException, IOException, JRException {
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		HashMap<String, Object> parametros = new HashMap<String, Object>() {{
	        put("COR", getCorSelecionada());
	    }};
		gerarRelatorio.gerarRelatorio("lista-bike-cor", parametros, "relatorio");
	}
	
	public String getCorSelecionada() {
		return corSelecionada;
	}

	public void setCorSelecionada(String corSelecionada) {
		this.corSelecionada = corSelecionada;
	}
	
	public Bicicleta.CorBicicleta[] getCores() {
		return Bicicleta.CorBicicleta.values();
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	
	public List<Bicicleta> getBicicletas() throws SQLException{
		return this.daoBicicleta.listaBicicletas();
	}
	public Bicicleta getBicicleta(int id) throws SQLException{
		return this.daoBicicleta.buscarBicicleta(id);
	}
	
	public Bicicleta getCorBicicleta(String cor) {
		return this.daoBicicleta.filtarBuscaDeBicicletaPelaCor(cor);
	}
}
