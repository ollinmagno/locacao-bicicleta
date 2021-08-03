package br.com.locacao.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.locacao.dao.UsuarioDAO;
import br.com.locacao.modelo.Cliente;
import br.com.locacao.util.RedirectView;

@ManagedBean
@ViewScoped
public class LoginBean {
	private Cliente usuario = new Cliente();
	
	public Cliente getUsuario() {
		return usuario;
	}
	
	public RedirectView efetueLogin() throws SQLException {
		System.out.println("fazendo login do usuário: "+ this.usuario.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioDAO().usuarioExiste(this.usuario);
		if(existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return new RedirectView("bicicletas");
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		return new RedirectView("login");
	}
	
	public RedirectView deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return new RedirectView("login");
	}
}
