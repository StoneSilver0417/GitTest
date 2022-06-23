package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private Connection conn; //2)Ŀ�ؼ� ����-�ٸ������� ����ϱ⶧���� ���������� ����
	private Statement stmt;
	private PreparedStatement pstmt;

	public Connection getCon() {
		return conn;
	}
	public Db() {
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // 1) ����̹� ã�� ����ó���ϱ�
			conn=DriverManager.getConnection(url, user, pwd);
			}			
			catch (SQLException e) {
				e.printStackTrace();	
				}
		
			catch (ClassNotFoundException e) {
				e.printStackTrace();//���ܹ߻��� ����� ��
				}
			}
	
		public Connection getConn() {
			return conn;
			}
		public Statement getStatement(){
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace(); // statement ����ó��
			}
			return stmt;
		}
		public PreparedStatement getPreparedStatement(String sql) {
			try {
				pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pstmt;
			
		}
	} 
	
