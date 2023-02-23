package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Usuario e senha do banco de dados
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	//caminho do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	
	//conexão banco de dados
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//cria conexão
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		
		//Recuperar uma coneão com banco
		Connection con = createConnectionToMySQL();
		
		//testa se conexão é null
		if(con!=null) {
			System.out.println("Conexão obtida!");
			con.close();
		}
	}
}
