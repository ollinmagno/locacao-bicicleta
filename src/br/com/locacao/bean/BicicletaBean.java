package br.com.locacao.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.locacao.dao.BicicletaDAO;
import br.com.locacao.modelo.Bicicleta;

@ManagedBean
@ViewScoped
public class BicicletaBean {
	private Bicicleta bicicleta = new Bicicleta();
	private List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
	
	
}
