package br.com.locacao.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.locacao.dao.LocacaoDAO;
import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Locacao;
import br.com.locacao.util.RedirectView;

@ManagedBean
@ViewScoped
public class LocacaoBean {
	private Locacao locacao = new Locacao();
	private LocacaoDAO daoLocacao = new LocacaoDAO();
	
	public Locacao getLocacao() {
		return this.locacao;
	}
	public List<Locacao> getLocacoes() throws SQLException{
		return this.daoLocacao.historicoGeralDeLocacao();
	}
	public List<Locacao> getSituacaoDaLocacao(int situacao) throws SQLException{
		return this.daoLocacao.verificarSituacaoDaLocacao(situacao);
	}
	
	public RedirectView redirecionarParaLocacao() {
		 return new RedirectView("locacao");
//		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().
//				getRequest();
//		String contextPath = request.getContextPath();
//		String pagina = "/locacao.xhtml";
//		String parametros = "?bicicleta_id=" + bicicleta.getId();
//		FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + pagina + parametros);
	}
}
