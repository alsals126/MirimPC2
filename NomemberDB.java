package GUIDB;

import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//NomemberŬ�������� db������ �ʿ��� �޼������ ��Ƴ��� Ŭ����
class DBNomember{
	
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hwangyouna0415!";
    private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";
    
    Properties info = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs = null;
    
	public DBNomember() {// connection��ü�� �����ؼ� ��� ��������
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("���Ἲ��");
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Ŭ���� ���� ����!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("���� ����!!");
        }
    }
	
	//sys.nomember DB�� �ӽ��ڵ� ����Ŭ����
    public String insertTemporarycode() {
    	NomemberDB n1 = new NomemberDB(sql);
    	String sql = "insert into sys.nomember(temporarycode, created_date) values(?, ?);";
        //String sql = "insert into sys.nomember(temporarycode) values(?);";
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            n1.temporarycode();
            pstmt.setString(1, n1.gettem());
            pstmt.setInt(2, 0);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) 
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n1.gettem();
    }
    
    //���̵� �ִ��� ������ �����ϴ� Ŭ����
    public int setTemcode(String temporaryID) {
    	int result = 1;
    	
    	try {
            stmt = conn.createStatement();
            sql = "select * from sys.nomember where temporarycode='" + temporaryID + "';";
            rs = stmt.executeQuery(sql); // �о���°Ŷ� �ٸ��� ����    //����Ÿ���� ResultSet
 
            if (rs.next() == false)// id�� ����x
               result = 1;
            else 				   // id����
               result = 0;         
        } catch (Exception ee) {
            System.out.println("��������");
            ee.printStackTrace();
        }
    	return result;
    }
}

//��ȸ���� ��Ÿ���� Ŭ����
public class NomemberDB /*extends LoginDB*/{
	private static String temporaryID;
	Scanner scan = new Scanner(System.in);
	
	//�����ڸ޼���
	
	public NomemberDB(String temporaryID) {
	this.temporaryID = temporaryID;
	}
	
	//getter and setter
	public String gettem() {
		return temporaryID;
	}
	public void settem(String temporaryID) {
		this.temporaryID = temporaryID;
	}
	
	//DBNomember���� setTemcode()�޼��尡������ Ŭ����
	public int setTemcode() {
		int num;
		String entertemporaryID;
		DBNomember db1 = new DBNomember();
		
		System.out.print("�ӽ��ڵ� : ");
		entertemporaryID = scan.next();
		num = db1.setTemcode(entertemporaryID);	//�Է��� �ӽ��ڵ尡 �ִ��� ������ �Ǻ��ϱ����� DBNomember���� setTemcode�޼��� �ҷ�����
		
		return num;
	}
	
	//�ӽ��ڵ� �߱� �޼���
	public void temporarycode() {
		String temcode;
		
		for (int i = 0; i < 1; i++) {
			temcode = UUID.randomUUID().toString().replaceAll("-", ""); // -�� ������ �־���.
		    temcode = temcode.substring(0, 8); //temcode�� �տ������� 8�ڸ� �߶���
		    this.temporaryID = temcode;
		}
	}		
	
	//��ȸ������ �α����ϱ�
	public int letLogin() {
		int num;  	
    	num = setTemcode();
    	
    		
    	 if(num == 1) { //�Է��� �ӽ��ڵ尡 DB�� ������
    		System.out.println("ã���ô� �ӽ��ڵ尡 �����ϴ�. �ٽ� �Է����ּ���.");
    		letLogin();
    	}
    	return num;
	}
	
	
	//toString()
	public String toString() {
		return "�ӽ��ڵ�� " + temporaryID + "�Դϴ�.";
	}
	
	//Nomember�� ����� ���� Ŭ����
	public void callNomember() {
		
		DBNomember n1 = new DBNomember();
		
		settem(n1.insertTemporarycode());
		System.out.println(toString());
		
		
	}
	
	public static void main(String args[]) {
		
	}
}