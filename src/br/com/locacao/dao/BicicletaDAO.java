package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.locacao.modelo.Bicicleta;

public class BicicletaDAO {

	public void adicionaBicicleta(Bicicleta bicicleta) throws SQLException {
		String sql = "INSERT INTO bicicleta(ARO, COR, MARCHAS) VALUES(?,?,?)";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, bicicleta.getAro());
				pstm.setString(2, bicicleta.getCor());
				pstm.setInt(3, bicicleta.getMarchas());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
}
