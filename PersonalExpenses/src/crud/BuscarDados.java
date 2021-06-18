package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.FabricaConexao;

public class BuscarDados {

	/*
	 * public void limparTabela(DefaultTableModel _model, JTable _table) { int
	 * maxRow = _table.getRowCount(); System.out.println(maxRow);
	 * 
	 * for(int i = 0; i < maxRow;i++) {
	 * 
	 * _model.removeRow(i);
	 * 
	 * } }
	 */

	public void buscarDAO(JTable _table) {

		Connection conexao;

		try {

			conexao = FabricaConexao.getConexao();
			String sql = "SELECT * FROM tb_expenses";
			Statement stmt = conexao.createStatement();
			ResultSet rSet = stmt.executeQuery(sql);

			DefaultTableModel modelo = (DefaultTableModel) _table.getModel();
			modelo.setRowCount(0);

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

				modelo.addRow(tableData);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void buscarMaiorPreco(JTable _table, int _categoria, JCheckBox _checkbox) {
		Connection conexao;

		String sql;
		try {
			conexao = FabricaConexao.getConexao();
			if(!_checkbox.isSelected()) {
				sql = "SELECT * FROM tb_expenses WHERE cl_categoria = " +_categoria;
			}else {
				sql = "SELECT * FROM tb_expenses WHERE cl_categoria = "+_categoria+" ORDER BY cl_valor DESC";
			}
			Statement stmt = conexao.createStatement();
			//stmt.setInt(1, _categoria);
			//System.out.println(_categoria);
			
			ResultSet rSet = stmt.executeQuery(sql);

			DefaultTableModel modelo = (DefaultTableModel) _table.getModel();
			modelo.setRowCount(0);

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

				modelo.addRow(tableData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void buscarCategoria(JTable _table, int _categoria) {
		Connection conexao;

		try {
			conexao = FabricaConexao.getConexao();
			String sql = "SELECT * FROM tb_expenses WHERE cl_categoria = " + _categoria;
			Statement stmt = conexao.createStatement();
			ResultSet rSet = stmt.executeQuery(sql);

			DefaultTableModel modelo = (DefaultTableModel) _table.getModel();
			modelo.setRowCount(0);

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

				modelo.addRow(tableData);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void buscarNome(JTable _table, int _categoria, JCheckBox _checkbox) {
		Connection conexao;
			String sql;
		try {
			conexao = FabricaConexao.getConexao();
			if(!_checkbox.isSelected()) {
				sql = "SELECT * FROM tb_expenses WHERE cl_categoria = " +_categoria;
			}else {
				sql = "SELECT * FROM tb_expenses WHERE cl_categoria = "+_categoria+" ORDER BY cl_nome ASC";
			}
			
			Statement stmt = conexao.createStatement();
			ResultSet rSet = stmt.executeQuery(sql);

			DefaultTableModel modelo = (DefaultTableModel) _table.getModel();
			modelo.setRowCount(0);

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

				modelo.addRow(tableData);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
