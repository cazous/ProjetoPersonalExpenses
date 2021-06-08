package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class openConnection {

	public static void abrirConexao(String[] args) {
		String getConnection = "jdbc:mysql://localhost:3306/";
		final String usuario = "admin";
		final String senha = "admin";

		try {
			Connection conexao = DriverManager.getConnection(getConnection, usuario, senha);
			System.out.println("Conectado com sucesso");
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de conexão: " + e);
			
		}
	}

}
