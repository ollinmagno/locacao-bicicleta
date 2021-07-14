package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Cliente;
import br.com.locacao.modelo.Locacao;
import br.com.locacao.modelo.Modelo;
import br.com.locacao.modelo.Situacao;

public class LocacaoDAO {

	public void fazerLocacao(Locacao locacao)
			throws SQLException {
		String sql = "INSERT INTO LOCACAO(hora_da_locacao, devolucao, id_cliente, id_situacao, id_bicicleta)"
				+ " VALUES(CURRENT_TIMESTAMP, ?, ?, ?, ?)";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				//pstm.setDate(1, new java.sql.Date(locacao.getHoraDaLocacao().getHour()));
				pstm.setDate(1, new java.sql.Date(locacao.getDevolucacao().getHour()));
				pstm.setInt(2, locacao.getCliente().getId());
				pstm.setInt(3, locacao.getSituacao().getId());
				pstm.setInt(4, locacao.getBicicleta().getId());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
