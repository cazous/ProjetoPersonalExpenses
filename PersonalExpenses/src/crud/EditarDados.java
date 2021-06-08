package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.FabricaConexao;

public class EditarDados {
	public void editarDAO(int _id, String _nome, float _valor, int _categoria) {

		Connection conexao;
		try {
			conexao = FabricaConexao.getConexao();
			String sql = "UPDATE tb_expenses SET cl_nome =?, cl_valor=?, cl_categoria=?" + "WHERE id=?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, _nome);
			stmt.setFloat(2, _valor);
			stmt.setInt(3, _categoria);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
