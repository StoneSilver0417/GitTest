package db01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
	Db db1 = new Db();
	Scanner sc= new Scanner(System.in);
	
	while(true) {
		System.out.println("1.입력 2출력 3삭제 4수정 0종료");
		int a=Integer.parseInt(sc.nextLine());
		if(a==1) {
			System.out.println("이름");
			String name1=sc.nextLine();
			System.out.println("번호");
			String num1=sc.nextLine();
			
			String query="insert into test02 values(?,?)";
			PreparedStatement psmt=db1.getPreparedStatement(query);
			try {
				psmt.setString(1, name1);
				psmt.setString(2, num1);
				psmt.executeUpdate();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}
			
			}else if(a==2) {
				Statement stm = db1.getStatement();
				try {
					ResultSet rs=stm.executeQuery("select*from test02");
					while(rs.next()) {
						System.out.println(rs.getString(1) +rs.getString(2));
					}
					rs.close();
					stm.close();
					} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(a==3) {
				System.out.println("삭제할 이름");
				String name1=sc.nextLine();
				
				String query="Delete from test02 where name=?";
				PreparedStatement pstmt=db1.getPreparedStatement(query);
				
				try {
					pstmt.setString(1, name1);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(a==4) {
				System.out.println("수정할 이름");
				String name1=sc.nextLine();
				System.out.println("수정할 번호");
				String num1=sc.nextLine();
				
				String query="update test02 set NUM=? where name=?";
				PreparedStatement pstmt=db1.getPreparedStatement(query);
				
				try {
					pstmt.setString(1, num1);
					pstmt.setString(2, name1);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
				
			}else if(a==0) {
				System.out.println("프로그램 종료");
				try {
					db1.getConn().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		
		}
	}
}
