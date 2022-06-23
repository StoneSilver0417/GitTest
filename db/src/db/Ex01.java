package db;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex01 {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 있음");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/java";
			String id = "root";
			String pass = "1";
			conn=DriverManager.getConnection(url, id, pass);
			System.out.println("===>"+conn);
			
			Statement stm=conn.createStatement();
			System.out.println("===."+stm);
			ResultSet rs=stm.executeQuery("select*from test");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getString(2));
			}
			rs.close();
			stm.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("드라이버 없음"+e);
		}
	}
}
