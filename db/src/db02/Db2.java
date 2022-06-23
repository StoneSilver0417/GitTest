package db02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db2 {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;

	public Db2() {
		String url ="jdbc:mariadb://localhost:3306/java";
		String user = "root";
		String pwd = "1";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user,pwd);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			    e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public PreparedStatement getPstmt(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public Statement getStmt() {
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}//set는 왜 필요없는가 , sql이 먼가
	
	
	
}

