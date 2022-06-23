package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private Connection conn; //2)커넥션 연결-다른곳에도 써야하기때문에 지역변수에 선언
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
			Class.forName("org.mariadb.jdbc.Driver"); // 1) 드라이버 찾고 예외처리하기
			conn=DriverManager.getConnection(url, user, pwd);
			}			
			catch (SQLException e) {
				e.printStackTrace();	
				}
		
			catch (ClassNotFoundException e) {
				e.printStackTrace();//예외발생시 여기로 감
				}
			}
	
		public Connection getConn() {
			return conn;
			}
		public Statement getStatement(){
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace(); // statement 예외처리
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
	
