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
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.����:");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("�̸�=");
				String name=sc.nextLine();
				System.out.print("��ȭ��ȣ=");
				String num_ber=sc.nextLine();
				
				String query="insert into test02 values(?,?)";
				PreparedStatement pstmt=db.getPreparedStatement(query); // �Լ� �ܿ��
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
				System.out.print("���� �� �̸�=");
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
				System.out.print("��ȭ��ȣ ���� �� �̸�=");
				String name=sc.nextLine();
				System.out.print("���� �� ��ȭ��ȣ=");
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
				System.out.println("���α׷�����.");
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
