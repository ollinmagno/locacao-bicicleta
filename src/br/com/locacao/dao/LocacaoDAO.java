package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Cliente;
import br.com.locacao.modelo.Locacao;
import br.com.locacao.modelo.Modelo;
import br.com.locacao.modelo.Situacao;

public class LocacaoDAO {

	public void fazerLocacao(Locacao locacao) throws SQLException {
		String sql = "INSERT INTO LOCACAO(hora_da_locacao, devolucao, id_cliente, id_situacao, id_bicicleta)"
				+ " VALUES(CURRENT_TIMESTAMP, ?, ?, ?, ?)";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				// pstm.setDate(1, new java.sql.Date(locacao.getHoraDaLocacao().getHour()));
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

	public List<Locacao> historicoGeralDeLocacao() throws SQLException {
		List<Locacao> historicoDeLocacao = new ArrayList<Locacao>();

		String sql = "SELECT LOCACAO.HORA_DA_LOCACAO, LOCACAO.DEVOLUCAO, CLIENTE.NOME"
				+ ", CLIENTE.CPF, SITUACAO.STATUS as SITUACAO\r\n"
				+ "FROM LOCACAO JOIN CLIENTE ON LOCACAO.ID_CLIENTE = CLIENTE.ID"
				+ " JOIN SITUACAO ON LOCACAO.ID_SITUACAO = SITUACAO.ID;";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Locacao locacao = new Locacao();
						//bicicleta.setAro(resultset.getInt(1));			
						//locacao.setHoraDaLocacao(resultset.getInt(1));
						//locacao.setDevolucacao(resultset.getInt(2));						
						locacao.getCliente().setNome(resultset.getString(3));;
						locacao.getCliente().setCpf(resultset.getString(4));
						locacao.getSituacao().setStatus(resultset.getString(5));
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}
		return historicoDeLocacao;
	}
}
