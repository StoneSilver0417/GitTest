package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05 {
	public static void main(String[]args) throws Exception {//예외신경쓰지않겠다 - exception
	Scanner sc=new Scanner(System.in);
	
	String url="jdbc:mariadb://localhost:3306/java";
	String user="root";
	String pwd="1"; //3 세개 선언
	
	
	Class.forName("org.mariadb.jdbc.Driver"); // 1) 드라이버 연결하기, 예외처리하기 classnotfoundexception인데 exception만 남김(공부를위해)
	Connection conn=DriverManager.getConnection(url, user, pwd); //2) url user password 가 필요함 //4url user pwd 넣기
	
	System.out.println(conn);//5 잘 연결됐는지 확인
	while(true) {
		System.out.print("1.입력 2.출력 3.종료");
		int s=Integer.parseInt(sc.nextLine());
		
		if(s==1) {
			String query="INSERT INTO ex04 VALUES(null,?,?)";
			System.out.print("이름 : ");
			String name=sc.nextLine();
			System.out.print("주민번호 : ");
			String jumin=sc.nextLine(); //db에 넣어줘야하기에 선언
			
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			int a=pstmt.executeUpdate(); // 
			System.out.println("a="+a);
			pstmt.close();
			
		}else if(s==2) {
			String query="select*from ex04";
			Statement smt=conn.createStatement();
			smt.executeUpdate(query);
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+""+rs.getString(3));
			}
			rs.close();
			JdbcUtil.close(smt);
		}else if(s==3) {
			break;
		
			}
		}
			System.out.println("프로그램 종료.");
			JdbcUtil.close(conn); //떙겨오면 예외처리안하고 편함
	}
}
