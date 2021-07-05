package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.locacao.modelo.Bicicleta;
import br.com.locacao.modelo.Cliente;

public class UsuarioDAO {
	
	public boolean existe(Cliente cliente) throws SQLException {
		return true;
	}
}
