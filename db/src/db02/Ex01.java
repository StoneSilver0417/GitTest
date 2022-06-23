package db02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Db db = new Db();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.print("1.입력 2.출력 3.삭제 4.수정 0.종료:");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("이름=");
				String name=sc.nextLine();
				System.out.print("전화번호=");
				String num_ber=sc.nextLine();
				
				String query="insert into test02 values(?,?)";
				PreparedStatement pstmt=db.getPreparedStatement(query); // 함수 외우기
				try {
					pstmt.setString(1, name);
					pstmt.setString(2, num_ber);
					pstmt.executeUpdate();
					pstmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==2) {
				Statement stmt=db.getStatement();
				try {
					
					ResultSet rs=stmt.executeQuery("select * from test02");
					while(rs.next()) {
						System.out.println(rs.getString(1)+" : "+rs.getString(2));
					}
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==3) {
				System.out.print("삭제 할 이름=");
				String name=sc.nextLine();
				
				String query="DELETE FROM test02 WHERE NAME=?";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				try {
					pstmt.setString(1,name);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==4) {
				System.out.print("전화번호 수정 할 이름=");
				String name=sc.nextLine();
				System.out.print("수정 할 전화번호=");
				String num_ber=sc.nextLine();
				
				String query="UPDATE test02 SET NUM_BER=? WHERE NAME=?";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				try {
					pstmt.setString(1, num_ber);
					pstmt.setString(2, name);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(s==0) {
				System.out.println("프로그램종료.");
				try {
					db.getConn().close();
					
					System.exit(0);
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
		}

	}

}
