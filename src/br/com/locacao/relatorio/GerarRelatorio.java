package br.com.locacao.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.locacao.dao.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class GerarRelatorio {
	private HttpServletResponse response;
	private FacesContext context;

	public GerarRelatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	public void gerarRelatorio(String nomeRelatorio, Map<String, Object> parametros, String nomeArquivo) throws SQLException, ServletException, IOException, JRException {
		String relatorio = "/WEB-INF/jasper/"+nomeRelatorio+".jasper";

		InputStream reportStream = context.getExternalContext().getResourceAsStream(relatorio);

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment;filename="+nomeArquivo+".pdf");

		ServletOutputStream servletOutputStream = response.getOutputStream();

		Connection connection = null;

		try {
			connection = new ConnectionFactory().recuperarConexao();

			JasperRunManager.runReportToPdfStream(reportStream, response.getOutputStream(), parametros, connection);

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			connection.close();
		}

		FacesContext.getCurrentInstance().responseComplete();
		servletOutputStream.flush();
		servletOutputStream.close();
	}
}