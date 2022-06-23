package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {

	public static void main(String[] args) {
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String password="1";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 있음");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select*from test02");
			while(rs.next()) {
			System.out.println(rs.getString(1)+":"+rs.getString(2));
			}
			rs.close();
			stm.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버없음"+ e);
		} catch (SQLException e) {
			System.out.println("====>"+ e);
		}

	}

}
