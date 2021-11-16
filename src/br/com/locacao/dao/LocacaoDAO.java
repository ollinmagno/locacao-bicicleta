package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Cliente;
import br.com.locacao.modelo.Locacao;
import br.com.locacao.modelo.Modelo;
import br.com.locacao.modelo.Situacao;

public class LocacaoDAO {
	
	public void gravarLocacao(Locacao locacao) throws SQLException {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().recuperarConexao();
			connection.setAutoCommit(false);
			boolean inserirFuncionou = fazerLocacao(connection, locacao);
			boolean setarBicicletaFuncionou = setarBicicletaComoIndisponivel(connection, locacao.getBicicleta());
			
			if(inserirFuncionou && setarBicicletaFuncionou) {
				connection.commit();
			}
		}catch (SQLException e) {
			System.out.println(e);
		} finally {
			connection.close();
		}
	}
	
	private boolean setarBicicletaComoIndisponivel(Connection connection, Bicicleta bicicleta) {
		boolean funcionou = false;
		String sql = "update bicicleta set disponivel = ? where (id = ?)";
		
		try {
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setBoolean(1, false);
				pstm.setInt(2, bicicleta.getId());
				pstm.execute();
			}
			funcionou = true;
		}catch(SQLException e) {
			System.out.println(e);
		} 
		return funcionou;
	}
	
	private boolean fazerLocacao(Connection connection, Locacao locacao) throws SQLException {
		boolean funcionou = false;
		
		String sql = "insert into locacao(hora_da_locacao, devolucao, id_cliente, id_situacao, id_bicicleta)"
				+ " values(?, ?, ?, ?, ?)";
		try {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setDate(1, new java.sql.Date(locacao.getHoraDaLocacao().getHour()));
				pstm.setDate(2, new java.sql.Date(locacao.getDevolucacao().getHour()));
				pstm.setInt(3, locacao.getCliente().getId());
				pstm.setInt(4, locacao.getSituacao().getId());
				pstm.setInt(5, locacao.getBicicleta().getId());
				pstm.execute();
			}
			funcionou = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funcionou;
	}

	public List<Locacao> historicoGeralDeLocacao() throws SQLException {
		List<Locacao> historicoDeLocacoes = new ArrayList<Locacao>();

		String sql = "select hora_da_locacao, devolucao, nome, cpf, status, bicicleta.id,\r\n" + 
				"bicicleta.aro, bicicleta.cor, bicicleta.marchas,\r\n" + 
				"modelo.marca, modelo.preco_por_hora\r\n" + 
				"from locacao join cliente on id_cliente = cliente.id join situacao on\r\n" + 
				"id_situacao = situacao.id join bicicleta on id_bicicleta = bicicleta.id\r\n" + 
				"join modelo on id_bicicleta = modelo.id";

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

		String sql = "select hora_da_locacao, devolucao, nome, cpf, status from "
				+ "Locacao join cliente on id_cliente = cliente.Id join situacao "
				+ "On id_situacao = situacao.Id where id_situacao = ?";

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
