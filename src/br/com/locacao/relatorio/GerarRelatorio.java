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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locacao.dao.ConnectionFactory;

public class GerarRelatorio {
	private HttpServletResponse response;
	private FacesContext context;
	private ByteArrayOutputStream baos;
	private InputStream stream;
	
	public GerarRelatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	public void gerarRelatorio() throws SQLException, ServletException, IOException {
		Connection connection = null;
		stream = Thread.currentThread().getClass().getResourceAsStream("/WEB-INF/jasper/listabike.jasper");
		Map<String, Object> parametros = new HashMap<String, Object>();
		baos = new ByteArrayOutputStream();
		
		try {
			connection = new ConnectionFactory().recuperarConexao();
			
			Relatorio gerador = new Relatorio(this.stream, parametros, connection, this.baos);
			gerador.geraPDF();
			response.reset();
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
			response.getOutputStream().write(baos.toByteArray());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			context.responseComplete();

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			connection.close();
		}
	}
}
