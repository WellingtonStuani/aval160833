package br.univel.wellington.meusistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
	
	private static final String SQL_BUSCA_TODOS = "SELECT * FROM CONTATO";

	public List<Produto> getTodos() {
		
		Connection con = ConexaoDB
				.getInstance()
				.getConnection();
		
		List<Produto> lista = new ArrayList<>();
		try (PreparedStatement ps = con
					.prepareStatement(SQL_BUSCA_TODOS);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setDescrcao(rs.getString(2));
				p.setQuantidade(rs.getInt(3));
				lista.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void insere(Produto p) {
		
	}
	
	public void atualiza(int id, Produto c) {
		
	}
	
	public void exclui(int id) {
		
	}
	
}


