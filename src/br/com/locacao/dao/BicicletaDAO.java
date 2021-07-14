package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Modelo;

public class BicicletaDAO {

	public void adicionaBicicleta(Bicicleta bicicleta, Modelo modelo) throws SQLException {
		String sql = "INSERT INTO bicicleta(ARO, COR, MARCHAS, ID_FK_MODELO) VALUES(?,?,?,?)";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, bicicleta.getAro());
				pstm.setString(2, bicicleta.getCor());
				pstm.setInt(3, bicicleta.getMarchas());
				pstm.setInt(4, modelo.getId());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Bicicleta> listaBicicletas() throws SQLException {
		List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();

		String sql = "SELECT ARO, COR, MARCHAS FROM BICICLETA";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Bicicleta bicicleta = new Bicicleta();
						bicicleta.setAro(resultset.getInt(1));
						bicicleta.setCor(resultset.getString(2));
						bicicleta.setMarchas(resultset.getInt(3));
						bicicletas.add(bicicleta);
					}
				}catch(SQLException e) {
					System.out.println(e);
				}

			}
		}
		return bicicletas;
	}
	

}
