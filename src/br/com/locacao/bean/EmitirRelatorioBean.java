package br.com.locacao.bean;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;

import br.com.locacao.relatorio.GerarRelatorio;

@ManagedBean
@ViewScoped
public class EmitirRelatorioBean {
	
	public void emitirRelatorioAction() throws SQLException, ServletException, IOException {
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		gerarRelatorio.gerarRelatorio();
	}
}
