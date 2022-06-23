package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db02 {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;

public Db02() {
	String url="jdbc:mariadb://localhost:3306/java";
	String user="root";
	String pwd="1";
	
	try {
		Class.forName("org.mariadb.jdbc.Driver"); //대문자 [C]lass 는 밖에 만들어져있는 클래스를 떙겨쓸때 사용
		conn=DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 catch (ClassNotFoundException e) {
			e.printStackTrace();
	 		}
		}

		public Connection getConn() {
			return conn;
}

		public Statement getStmt() {
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return stmt;
}

		public PreparedStatement getPstmt(String sql) {
			try {
				pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pstmt;
}


	}
	











