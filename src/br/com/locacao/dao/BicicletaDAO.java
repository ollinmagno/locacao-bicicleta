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

	public void adicionaBicicleta(Bicicleta bicicleta) throws SQLException {
		String sql = "INSERT INTO bicicleta(ARO, COR, MARCHAS, ID_FK_MODELO) VALUES(?,?,?,?);";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, bicicleta.getAro());
				pstm.setString(2, bicicleta.getCor());
				pstm.setInt(3, bicicleta.getMarchas());
				pstm.setInt(4, bicicleta.getModelo().getId());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Bicicleta> listaBicicletas() throws SQLException {
		List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();

		String sql = "SELECT BICICLETA.ID, ARO, COR, MARCHAS,\r\n"
				+ "MARCA, PRECO_POR_HORA FROM BICICLETA JOIN MODELO ON BICICLETA.ID_FK_MODELO = MODELO.ID;";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Bicicleta bicicleta = new Bicicleta(new Modelo());
						bicicleta.setId(resultset.getInt(1));
						bicicleta.setAro(resultset.getInt(2));
						bicicleta.setCor(resultset.getString(3));
						bicicleta.setMarchas(resultset.getInt(4));
						bicicleta.getModelo().setMarca(resultset.getString(5));
						bicicleta.getModelo().setPrecoPorHora(resultset.getDouble(6));
						bicicletas.add(bicicleta);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}
		return bicicletas;
	}

	public Bicicleta buscarBicicleta(int id) {
		Bicicleta bicicleta = new Bicicleta(new Modelo());
		String sql = "SELECT BICICLETA.ID, ARO, COR, MARCHAS, MARCA, PRECO_POR_HORA FROM BICICLETA"
				+ " JOIN MODELO ON BICICLETA.ID_FK_MODELO = MODELO.ID WHERE BICICLETA.ID = ?";

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, id);
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						bicicleta.setId(resultset.getInt(1));
						bicicleta.setAro(resultset.
								getInt(2));
						bicicleta.setCor(resultset.getString(3));
						bicicleta.setMarchas(resultset.getInt(4));
						bicicleta.getModelo().setMarca(resultset.getString(5));	
						bicicleta.getModelo().setPrecoPorHora(resultset.getDouble(6));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return bicicleta;
	}

}
