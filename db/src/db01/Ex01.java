package db01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Db db = new Db();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("1.입력 2.출력 3.삭제 4.수정 0.종료");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("전화번호 : ");
				String num=sc.nextLine();
				String query="insert into test02 values(?,?)";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				
				
				try {
					pstmt.setString(1, name);
					pstmt.setString(2, num);
					pstmt.executeUpdate();
					pstmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==2) {
				Statement stmt=db.getStatement();
				try {
					ResultSet rs = stmt.executeQuery("select*from test02");
					while(rs.next()) {
						System.out.println(rs.getString(1)+ " : " +rs.getString(2));
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==3) {
				System.out.println("삭제할 이름 = ");
				String name=sc.nextLine();
				String query="DELETE FROM test02 WHERE NAME=?"
						
			}	
			
			
			else if(s==0) {
				System.out.println("프로그램 종료.");
				try {
					db.getConn().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
