package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.FabricaConexao;

public class InserirDados {
	
	public void inserirDAO(String _nome, float _valor, int _categoria) {
		
		Connection conexao;
		try {
			conexao = FabricaConexao.getConexao();
			String sql = "INSERT INTO tb_expenses (cl_nome, cl_valor, cl_categoria) VALUES (?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, _nome);
			stmt.setFloat(2, _valor);
			stmt.setInt(3, _categoria);
			//AAAA-MM-DD hh:mm:ss
			//stmt.setString(4, data);
			
			stmt.execute();
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Erro de inserção");
		}
		
		
	}

}
