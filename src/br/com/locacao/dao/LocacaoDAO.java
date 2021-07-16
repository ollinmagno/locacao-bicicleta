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
import br.com.locacao.modelo.Situacao;

public class LocacaoDAO {

	public void fazerLocacao(Locacao locacao) throws SQLException {
		String sql = "INSERT INTO LOCACAO(hora_da_locacao, devolucao, id_cliente, id_situacao, id_bicicleta)"
				+ " VALUES(?, ?, ?, ?, ?)";
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setDate(1, new java.sql.Date(locacao.getHoraDaLocacao().getHour()));
				pstm.setDate(2, new java.sql.Date(locacao.getDevolucacao().getHour()));
				pstm.setInt(3, locacao.getCliente().getId());
				pstm.setInt(4, locacao.getSituacao().getId());
				pstm.setInt(5, locacao.getBicicleta().getId());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Locacao> historicoGeralDeLocacao() throws SQLException {
		List<Locacao> historicoDeLocacoes = new ArrayList<Locacao>();

		String sql = "SELECT HORA_DA_LOCACAO, DEVOLUCAO, NOME, CPF, STATUS\r\n"
				+ "FROM LOCACAO JOIN CLIENTE ON ID_CLIENTE = CLIENTE.ID JOIN SITUACAO ON ID_SITUACAO = SITUACAO.ID";

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Locacao locacao = new Locacao(new Cliente(1), new Bicicleta(1), new Situacao(1));
						// locacao.setHoraDaLocacao(resultset.getInt(1));
						// locacao.setDevolucacao(resultset.getInt(2));
						locacao.getCliente().setNome(resultset.getString(3));
						locacao.getCliente().setCpf(resultset.getString(4));
						locacao.getSituacao().setStatus(resultset.getString(5));
						historicoDeLocacoes.add(locacao);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}
		return historicoDeLocacoes;
	}

	public List<Locacao> verificarLocacoesEmAtraso() throws SQLException {
		List<Locacao> verificarLocacoesEmAtraso = new ArrayList<Locacao>();

		String sql = "SELECT HORA_DA_LOCACAO, DEVOLUCAO, NOME, CPF, STATUS FROM "
				+ "LOCACAO JOIN CLIENTE ON ID_CLIENTE = CLIENTE.ID JOIN SITUACAO "
				+ "ON ID_SITUACAO = SITUACAO.ID WHERE ID_SITUACAO = 2";

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Locacao locacao = new Locacao(new Cliente(1), new Bicicleta(1), new Situacao(1));
						// locacao.setHoraDaLocacao(resultset.getInt(1));
						// locacao.setDevolucacao(resultset.getInt(2));
						locacao.getCliente().setNome(resultset.getString(3));
						locacao.getCliente().setCpf(resultset.getString(4));
						locacao.getSituacao().setStatus(resultset.getString(5));
						verificarLocacoesEmAtraso.add(locacao);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}

		return verificarLocacoesEmAtraso;
	}
}
