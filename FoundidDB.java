package GUIDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FoundidDB {
	static final String USERNAME = "root";
	private static final String PASSWORD = "hwangyouna0415!";
	private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final int FoundID = 0;
	
	public FoundidDB() {
		
		
	}
	
	
	Scanner scan = new Scanner(System.in);
	
	//���̵� ã�� �� ��ȣ�����ϴ� �޼���
	public void chooseNum() {  
		int chooseNum;
		System.out.print("��ȣ : ");
		chooseNum = scan.nextInt();
		
		switch(chooseNum) {  
		case 1 : //Ȯ���� �����ϸ� LoginŬ������ �ҷ���
			Login l1 = new Login();
			l1.callLogin();	
			break;
		case 2 : //��Ҹ� �����ϸ� memberŬ������ �ҷ���
			//member m1 = new member();
			//m1.callMember();  
			break;
		default : //1,2�� ������ �ٸ� ��ȣ�� ������ ��� ����
			System.out.println("�ٽ��Է����ּ���.");
			chooseNum();  
			break;
		}
	}
	//���̵� ã�� �޼���
			public String foundID(String number) {
				String id = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				    
				         
				    Statement stmt = conn.createStatement();
				    ResultSet rs = null;
				    
				   
				       		 
				       	String sql = "SELECT * FROM sys.member where number ='" + number + "';";
				       	rs = stmt.executeQuery(sql);
				       	if(rs.next()) { //���̵� �ִ���(������ if�� ����)
				       		id = rs.getString("ID");
				     
				       	}else {
				       		id = "ã���ô� ID�� �����ϴ�.";
				       	}
				}catch(Exception e) { 
					System.err.println("Got an exception!");
				    System.err.println(e.getMessage());
				}
				return id;
			}
				    
			public String foundID2(String email) {
				String id = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				    
				         
				    Statement stmt = conn.createStatement();
				    ResultSet rs = null;
				    
				 	String sql = "SELECT * FROM sys.member where email ='" + email + "';";
			       	rs = stmt.executeQuery(sql);
			       	
			       	if(rs.next()) { //���̵� �ִ���(������ if�� ����)
			       		id = rs.getString("ID");
			     
			       
				
			       	}else {
			       		id = "ã���ô� ID�� �����ϴ�.";
			       	}
				
				}catch(Exception e) { 
					System.err.println("Got an exception!");
				    System.err.println(e.getMessage());
				}
				return id;
			}
	
			
		}

	
