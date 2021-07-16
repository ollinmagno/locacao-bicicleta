package br.com.locacao.bean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import br.com.locacao.dao.LocacaoDAO;
import br.com.locacao.modelo.Locacao;

@ManagedBean
public class LocacaoBean {
	private Locacao locacao = new Locacao();
	private LocacaoDAO daoLocacao = new LocacaoDAO();
	
	public Locacao getLocacao() {
		return this.locacao;
	}
	public List<Locacao> getLocacoes() throws SQLException{
		return this.daoLocacao.historicoGeralDeLocacao();
	}
	
}
