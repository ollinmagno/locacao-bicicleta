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

		String sql = "SELECT HORA_DA_LOCACAO, DEVOLUCAO, NOME, CPF, STATUS, BICICLETA.ID,\r\n" + 
				"BICICLETA.ARO, BICICLETA.COR, BICICLETA.MARCHAS,\r\n" + 
				"MODELO.MARCA, MODELO.PRECO_POR_HORA\r\n" + 
				"FROM LOCACAO JOIN CLIENTE ON ID_CLIENTE = CLIENTE.ID JOIN SITUACAO ON\r\n" + 
				"ID_SITUACAO = SITUACAO.ID JOIN BICICLETA ON ID_BICICLETA = BICICLETA.ID\r\n" + 
				"JOIN MODELO ON ID_BICICLETA = MODELO.ID";

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Locacao locacao = new Locacao(new Cliente(), new Bicicleta(new Modelo()), new Situacao());
						// locacao.setHoraDaLocacao(resultset.getInt(1));
						// locacao.setDevolucacao(resultset.getInt(2));
						locacao.getCliente().setNome(resultset.getString(3));
						locacao.getCliente().setCpf(resultset.getString(4));
						locacao.getSituacao().setStatus(resultset.getString(5));
						locacao.getBicicleta().setId(resultset.getInt(6));
						locacao.getBicicleta().setAro(resultset.getInt(7));
						locacao.getBicicleta().setCor(resultset.getString(8));
						locacao.getBicicleta().setMarchas(resultset.getInt(9));
						locacao.getBicicleta().getModelo().setMarca(resultset.getString(10));
						locacao.getBicicleta().getModelo().setPrecoPorHora(resultset.getDouble(11));
						historicoDeLocacoes.add(locacao);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}
		return historicoDeLocacoes;
	}

	public List<Locacao> verificarSituacaoDaLocacao(int situacao) throws SQLException {
		List<Locacao> verificarLocacoesEmAtraso = new ArrayList<Locacao>();

		String sql = "SELECT HORA_DA_LOCACAO, DEVOLUCAO, NOME, CPF, STATUS FROM "
				+ "LOCACAO JOIN CLIENTE ON ID_CLIENTE = CLIENTE.ID JOIN SITUACAO "
				+ "ON ID_SITUACAO = SITUACAO.ID WHERE ID_SITUACAO = ?";

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, situacao);
				try (ResultSet resultset = pstm.executeQuery()) {
					while (resultset.next()) {
						Locacao locacao = new Locacao(new Cliente(), new Bicicleta(), new Situacao());
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
