package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1";
		String query="insert into test02 values(?,?)";
		Connection conn=null;
		PreparedStatement pstm=null; //위로뺸이유 - 변수의 영역은 괄호를 벗어나면 인식을 못하기때문
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {System.out.println(e);}
		  catch (SQLException e) {System.out.println(e);} //예외처리-편하려고 하는것 애매한 문장
		
		while(true) {
			System.out.print("1.입력 2.출력 3.종료");
			int s= Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("이름 = ");
				String name=sc.nextLine();
				System.out.print("전화번호 = ");
				String num=sc.nextLine();
				
				try {
				pstm = conn.prepareStatement(query);
				pstm.setString(1, name);
				pstm.setString(2, num);
				pstm.executeUpdate();
					} 
					catch (SQLException e) {
					
				}
			}else if(s==3) {
				
				try {
					conn.close();
					pstm.close();
				} catch (SQLException e) {
					
					System.out.println(e);
				}
				System.exit(0);
			}
		}
	}
}
