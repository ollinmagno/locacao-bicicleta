package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.locacao.modelo.Cliente;

public class UsuarioDAO {

	public boolean usuarioExiste(Cliente cliente) throws SQLException {
		String sql = "SELECT EMAIL, SENHA FROM CLIENTE";
		boolean autenticaUsuario = false;
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				try (ResultSet result = pstm.executeQuery()) {
					while (result.next()) {
						boolean emailValido = cliente.getEmail().equals(result.getString(1));
						boolean senhaValida = cliente.getSenha().equals(result.getString(2));
						if(emailValido && senhaValida) {
							autenticaUsuario = true;
						}
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return autenticaUsuario;
	}
}
