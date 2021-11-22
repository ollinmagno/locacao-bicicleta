package br.com.locacao.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;

import br.com.locacao.relatorio.GerarRelatorio;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class EmitirRelatorioBean {
	
	public void emitirRelatorioAction() throws SQLException, ServletException, IOException, JRException {
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		gerarRelatorio.gerarRelatorio("lista-bike-cor", new HashMap<String, Object>(), "relatorio");
	}
}
