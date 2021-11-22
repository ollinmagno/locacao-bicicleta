package br.com.locacao.bean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.locacao.dao.BicicletaDAO;
import br.com.locacao.modelo.Bicicleta;

@ManagedBean
@ViewScoped
public class BicicletaBean {
	private Bicicleta bicicleta = new Bicicleta();
	private BicicletaDAO daoBicicleta = new BicicletaDAO();
	
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
