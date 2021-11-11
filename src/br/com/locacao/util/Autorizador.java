package br.com.locacao.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.locacao.modelo.Cliente;

public class Autorizador implements PhaseListener {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent evento) {
		
		FacesContext context = evento.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
		System.out.println(nomePagina);
		
		Cliente usuarioLogado = (Cliente) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null && nomePagina.equals("/login.xhtml")) {
			System.out.println("hello world autenticação.....................");
			NavigationHandler hand = context.getApplication().getNavigationHandler();
			hand.handleNavigation(context, null, "/bicicletas.xhtml?faces-redirect=true");
			context.renderResponse();
		}
		if("/login.xhtml".equals(nomePagina)) {
			return;
		}
		if(usuarioLogado == null) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
			context.renderResponse();
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent evento) {
		System.out.println("FASE: " + evento.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
