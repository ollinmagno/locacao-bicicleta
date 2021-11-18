package br.com.locacao.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio {
	private Map<String, Object> parametros;
	private Connection connection;
	private InputStream stream;
	private ByteArrayOutputStream baos;
	
	public Relatorio(InputStream stream, Map<String, Object> parametros, Connection connection, ByteArrayOutputStream baos) {
		this.stream = stream;
		this.parametros = parametros;
		this.connection = connection;
	}
	
	public void geraPDF() {
		JasperPrint jasperPrint = null;
		JasperReport report = null;
		
		try {
			report = (JasperReport) JRLoader.loadObject(this.stream);
			jasperPrint = JasperFillManager.fillReport(report, this.parametros, this.connection);
			JasperExportManager.exportReportToPdfStream(jasperPrint, this.baos);
			
		} catch(JRException e) {
			throw new RuntimeException(e);
		}
	}
}
