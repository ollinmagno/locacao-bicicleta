package br.com.locacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locacao.modelo.Bicicleta;

public class BicicletaDAO {
	
	private Connection connection;
	
	public BicicletaDAO(Connection connection){
		this.connection = connection;
	}
	
	public List<Bicicleta> listarBicicletas() throws SQLException {
		List<Bicicleta> listaBicicletas = new ArrayList<Bicicleta>();
		String sql = "SELECT ID, ARO, COR, MARCHAS FROM BICICLETA";
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Bicicleta bicicleta = 
							new Bicicleta(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getInt(4), null);
					listaBicicletas.add(bicicleta);
				}
			}
			return listaBicicletas;
		}
	}
	
}
