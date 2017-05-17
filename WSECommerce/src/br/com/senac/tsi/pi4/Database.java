package br.com.senac.tsi.pi4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static Database instance = null;
	
	private Database () {};
	
	public static Database get () {
		if (instance == null)
			instance = new Database();
		return instance;
	}
	
	public Connection conn () throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://delta-pi.database.windows.net;user=TSI@delta-pi.database.windows.net;password=SistemasInternet123;database=delta");
		return conn;
	}
	
}
