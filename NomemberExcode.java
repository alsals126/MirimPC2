package GUIDB;

import java.util.Calendar;
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
class DBNomember1{
	
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hwangyouna0415!";
    private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";
    
    Properties info = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
	public DBNomember1() {// connection��ü�� �����ؼ� ��� ��������
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//          System.out.println("���Ἲ��");
 
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
    	NomemberExcode n1 = new NomemberExcode();
        String sql = "insert into java.nomember(temporarycode, created_date) values(?, ?);";
        
        try {
            ps = conn.prepareStatement(sql);
            n1.temporarycode();
            ps.setString(1, n1.gettem());
            ps.setInt(2, n1.created_date());
            ps.executeUpdate(); 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) 
                    ps.close();
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
            sql = "select * from java.nomember where temporarycode='" + temporaryID + "';";
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
    
    //�Ϸ簡 ������ �ӽ��ڵ尡 ������� Ŭ����
    public void autodelete() {
    	NomemberExcode n1 = new NomemberExcode();
    	
    	try {
    		sql = "SELECT created_date FROM java.nomember;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); 
            while(rs.next()) {
            	if(rs.getInt("created_date") < n1.created_date()) {
            		sql="DELETE FROM java.nomember WHERE created_date = ?;";
            		ps = conn.prepareStatement(sql);
                    ps.setInt(1, rs.getInt("created_date"));
                    ps.executeUpdate(); 
            	}
            }
           
        } catch (Exception ee) {
            System.out.println("��������");
            ee.printStackTrace();
        }
    }
}

//��ȸ���� ��Ÿ���� Ŭ����
public class NomemberExcode{
	private String temporaryID;
	Scanner scan = new Scanner(System.in);
	
	//�����ڸ޼���
	public NomemberExcode(String temporaryID) {
		this.temporaryID = temporaryID;
	}
	public NomemberExcode() {}
	
	//getter and setter
	public String gettem() {
		return temporaryID;
	}
	public void settem(String temporaryID) {
		this.temporaryID = temporaryID;
	}
	
	//DBNomember���� setTemcode()�޼��尡������ Ŭ����
	public int setTemcode(String entertemporaryID) {
		int num;
		DBNomember1 db1 = new DBNomember1();
		num = db1.setTemcode(entertemporaryID);
		
//		int num;
//		String entertemporaryID;
//		DBNomember db1 = new DBNomember();
//		
//		System.out.print("�ӽ��ڵ� : ");
//		entertemporaryID = scan.next();
//		num = db1.setTemcode(entertemporaryID);	//�Է��� �ӽ��ڵ尡 �ִ��� ������ �Ǻ��ϱ����� DBNomember���� setTemcode�޼��� �ҷ�����
//		
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
	
	//�ӽ��ڵ� �߱� ��¥
	public int created_date() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		
		return (year+month+date);
	}
	
	//��ȸ������ �α����ϱ�
	public int letLogin() {
		int num, choosenum;  	
		System.out.println("---------------------------------------------");
		System.out.println("<��ȸ��-�α���>");
    	System.out.println("*1.Ȯ��   2.��� ");
    	
    	num = setTemcode(null);
    	
    	if(num == 0) { //�Է��� �ӽ��ڵ尡 DB�� ������
    		choosenum = choosenum();
    		
    		switch(choosenum) {
    		case 1 : //�¼��������� �Ѿ��
//    			Seat s1 = new Seat();
//    	    	s1.callSeat();
//    			break;
    		case 2 : //��(ó��)���� ���ư���
//    			Pcroom pc1 = new Pcroom(); 
//			 	pc1.main(null); 
//			 	break;
    		default : //1,2�� ������ ��ȣ�� �ԷµǾ��� �� ����
//    			System.out.println("�ٽ� �Է����ּ���");
//    			letLogin(); 
//    			break;  	 	
    		}
    	}else if(num == 1) { //�Է��� �ӽ��ڵ尡 DB�� ������
    		System.out.println("ã���ô� �ӽ��ڵ尡 �����ϴ�. �ٽ� �Է����ּ���.");
    		letLogin();
    	}
    	return num;
	}
	
	//��ȣ ����
	public int choosenum() {
		int choosenum;

		System.out.print("��ȣ : ");
		choosenum = scan.nextInt();
		return choosenum;
	}
	
	//toString()
	public String toString() {
		return "�ӽ��ڵ�� " + temporaryID + "�Դϴ�.";
	}
	
	//Nomember�� ����� ���� Ŭ����
	public void callNomember() {
		int choosenum;
		Scanner scan = new Scanner(System.in);
		
		DBNomember1 n1 = new DBNomember1();
		
		System.out.println("---------------------------------------------");
		System.out.println("<�ӽ��ڵ� �߱�>");
		System.out.println("*1.Ȯ��	2.���");
		settem(n1.insertTemporarycode());
		n1.autodelete();
		System.out.println(toString());
		choosenum = choosenum();
		
		switch(choosenum) {
		case 1 : //��ȸ���α��� �ҷ�����
			letLogin();  
			break;
		case 2 : //��(ó��)���� ���ư���
//			Pcroom pc1 = new Pcroom(); 
//			System.out.println("");
//			pc1.main(null);  
//			break;
		default : //1,2�� ������ ��ȣ�� ���õǾ��� �� ����
			System.out.println("�ٽ��Է����ּ���."); 
			callNomember(); 
			break;
		}
	}
}