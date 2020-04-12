package GUIDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//LoginŬ�������� db������ �ʿ��� �޼������ ��Ƴ��� Ŭ����
class LoginDB{
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hwangyouna0415!";
    private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";
    
    Properties info = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs = null;
    
    public LoginDB() {// connection��ü�� �����ؼ� ��� ��������
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
    
    //db�� �����Ͽ� �α����ϱ�
    public int letLogin(String id, String pw) {
    	Login l1 = new Login();
    	
//    	l1.setID();
//    	l1.setPW();
//    	String id = l1.getID();
//    	String pw = l1.getPW();
    	int result = 1;
    	
    	try {
            stmt = conn.createStatement();
            sql = "select * from sys.member where ID='" + id + "';";
            rs = stmt.executeQuery(sql); 
 
            if (rs.next() == false || (id.isEmpty()) == true) { // id�� ����x
                result = 1;
            } else {
                sql = "select * from sys.member where ID='" + id + "';";
                rs = stmt.executeQuery(sql);
                while (rs.next() == true) {         // ��������
                    if(rs.getString(3).equals(pw))  // pw�� ������ ��
                		result = 0;                 // ������ �α��� ����
                    else                 // ���̵�°��� pw�� �ٸ����
                        result = 1;
                }
            }
        } catch (Exception ee) {
            System.out.println("��������");
            ee.printStackTrace();
        }
        return result;
    }
}

//LoginŬ����
public class Login{
	private String ID;
	private String PW;
	Scanner scan = new Scanner(System.in);
	
	//������ �޼���
	public Login(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
	}
	public Login() {}

	//getter and setter
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setID() {
		System.out.print("ID : ");
		ID = scan.next();
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}	
	public void setPW() {
		System.out.print("PW : ");
		PW = scan.next();
	}
	
	
	//Login�� ����� ���� Ŭ����
	public void callLogin() {
		LoginCheck lc = new LoginCheck();
		
		lc.checkpwid();				
	}
	
		
//LoginCheckŬ����
class LoginCheck {
	private LoginDB ldb = new LoginDB();
	private Login l1 = new Login();
	private int num;
	
	Scanner scan = new Scanner(System.in);
	
	
	
	//�α����� �� �Ǿ����� �ȵǾ����� �˷��ִ� �޼���
	public void checkpwid() {
		//this.num = ldb.letLogin();
		if(num == 0) { 
			System.out.println("�α��� �Ǿ����ϴ�.");	
		}else {
			System.out.println("ID �Ǵ� PW�� Ȯ�����ּ���.");
			checkpwid();
			}
		}
	}
}