package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jdbc.FabricaConexao;

public class DeletarDados {
	public void deletarDAO(JTable _table) {
		Connection conexao;

		try {
			conexao = FabricaConexao.getConexao();
			int row = _table.getSelectedRow();
			int cellId = Integer.parseInt(_table.getModel().getValueAt(row, 0).toString());
			
			String sql = "DELETE FROM tb_expenses WHERE cl_id = " + cellId;
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.execute();

		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Erro de inserção");

		}

	}
}
