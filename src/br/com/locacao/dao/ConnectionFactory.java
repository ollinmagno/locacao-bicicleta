package br.com.locacao.dao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	DataSource dataSource;
	
	public ConnectionFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/locacao_bicicleta?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Admin123#");
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
}