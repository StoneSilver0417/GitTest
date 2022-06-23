package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("이름 = ");
		String name=sc.nextLine();
		System.out.print("전화번호 = ");
		String num=sc.nextLine();
			
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1";
		String query="insert into test02 values(?,?)";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstm=conn.prepareStatement(query);
			
			pstm.setString(1, name);
			pstm.setString(2, num);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
			
			} catch (SQLException e) {
				System.out.println("--->"+e);
			} catch(ClassNotFoundException e) {
				System.out.println("드라이버 없음");
			}
		
		}
	}

