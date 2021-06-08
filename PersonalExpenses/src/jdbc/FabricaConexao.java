package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConexao() {
		
		Connection conexao = null;

		try {
			//Método de conexao com o banco. Passa-se como string as informações relacionadas
			//ao banco que deseja acessar
			
			final String url = "jdbc:mysql://localhost:3306/db_expenses";
			final String usuario = "admin";
			final String senha = "admin";
			//instancia-se um objeto do tipo connection e utilizamos o método para criar a conexao
			//utilizando as variaveis do banco criadas como parametro e retornando esse objeto criado
			conexao = DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		return conexao;
	}
}
