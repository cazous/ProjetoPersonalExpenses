package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.FabricaConexao;

public class BuscarDados {

	public void buscarDAO(JTable _table) {

		Connection conexao;

		try {

			conexao = FabricaConexao.getConexao();
			String sql = "SELECT * FROM tb_expenses";
			Statement stmt = conexao.createStatement();
			ResultSet rSet = stmt.executeQuery(sql);

			while (rSet.next()) {
				String id = String.valueOf(rSet.getInt("cl_id"));
				String nome = rSet.getString("cl_nome");
				String valor = String.valueOf(rSet.getFloat("cl_valor"));
				String categoria = String.valueOf(rSet.getInt("cl_categoria"));

				if (rSet.getInt("cl_categoria") == 1) {
					categoria = "Alimentação";
				} else if (rSet.getInt("cl_categoria") == 2) {
					categoria = "Transporte";
				} else if (rSet.getInt("cl_categoria") == 3) {
					categoria = "Recreativos";
				} else if (rSet.getInt("cl_categoria") == 4) {
					categoria = "Metas";
				} else if (rSet.getInt("cl_categoria") == 5) {
					categoria = "Fixos";
				}

				String tableData[] = { id, nome, valor, categoria };

				DefaultTableModel modelo = (DefaultTableModel) _table.getModel();

				modelo.addRow(tableData);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
