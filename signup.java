package GUIDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import GUIDB.signupDB;

import java.awt.FlowLayout;
import javax.swing.JButton;

//DB
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern; //�н����峪 �̸��� Ȯ�ΰ��� ���ڿ� ���� ������ ��Ÿ���� ���� ���


public class signup extends JFrame {
	private JPanel contentPane;
	private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hwangyouna0415!";
    private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";

  
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public signup() {
		
		setTitle("ȸ������â");
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 1294, 815);
		panel.setLayout(null);
		
		JLabel label = new JLabel("ȸ������");
		label.setBounds(581, 41, 211, 75);
		label.setFont(new Font("����", Font.BOLD, 45));
		panel.add(label);
		
		JLabel name = new JLabel("�̸�");
		name.setBounds(376, 157, 76, 63);
		name.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		JLabel id = new JLabel("���̵�");
		id.setBounds(376, 232, 98, 63);
		id.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		JLabel password = new JLabel("��й�ȣ");
		password.setBounds(346, 307, 106, 63);
		password.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		JLabel c_password = new JLabel("��й�ȣ Ȯ��");
		c_password.setBounds(305, 382, 169, 63);
		c_password.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		
		JLabel number = new JLabel("��ȭ��ȣ");
		number.setBounds(346, 495, 128, 63);
		number.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		JLabel email = new JLabel("�̸���");
		email.setBounds(356, 570, 106, 63);
		email.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		
		//�ؽ�Ʈ�ڽ�
		JTextField txtname = new JTextField(3);
		txtname.setFont(new Font("���� ���", Font.PLAIN, 25));
		JTextField txtid = new JTextField(10);
		txtid.setFont(new Font("���� ���", Font.PLAIN, 25));
		JPasswordField txtpass = new JPasswordField(10);
		txtpass.setFont(new Font("���� ���", Font.PLAIN, 25));
		JPasswordField txtc_pass = new JPasswordField(10);
		txtc_pass.setFont(new Font("���� ���", Font.PLAIN, 25));
		JTextField txtnum = new JTextField(10);
		txtnum.setFont(new Font("���� ���", Font.PLAIN, 25));
		JTextField txtemail = new JTextField(10);
		txtemail.setFont(new Font("���� ���", Font.PLAIN, 25));
		
		//��ġ
		txtname.setBounds(505,166,344,56);
		txtid.setBounds(505,245, 344,49);
		txtpass.setBounds(505,320, 344,49);
		txtc_pass.setBounds(505, 395, 344,49);
		txtnum.setBounds(505,508, 344,49);
		txtemail.setBounds(505,579, 344,49);
		
		JButton signbtn = new JButton("�Ϸ�");
		signbtn.setBounds(555, 692, 246, 75);
		signbtn.setFont(new Font("���� ���", Font.PLAIN, 28));
		signbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(txtpass.getText().equals(txtc_pass.getText())) {
        			
        			if(txtnum.getText().equals("") && txtemail.getText().equals("")) {
        				JOptionPane.showMessageDialog(null, "��ȭ��ȣ �Ǵ� �̸����� �Է����ּ���");
        			}else {
        				Signup1 s1 = new Signup1();
                		s1.insertProfile(txtname.getText(), txtid.getText(),txtpass.getText(),txtnum.getText(),txtemail.getText());
                		JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�^^");
                		new Memberwindow();
                		dispose();
        			}
//        			Signup1 s1 = new Signup1();
//            		s1.insertProfile(txtname.getText(), txtid.getText(),txtpass.getText(),txtnum.getText(),txtemail.getText());
            		
        		}else {
        			JOptionPane.showMessageDialog(null, "��ġ���� �ʽ��ϴ�. �ٽ� Ȯ�����ֽʽÿ�.");
        		}
        		
        		
        		
        	}
				 
				
			
			
	});
        		
        	
	
		
		
		JLabel Label2 = new JLabel("����ȭ��ȣ �Ǵ� �̸����� �Է����ֽʽÿ�.��");
		Label2.setBounds(521, 478, 309, 18);
		Label2.setFont(new Font("���� ���", Font.PLAIN, 15));
		Label2.setForeground(Color.red);
		
		
		JButton btnback = new JButton("���ư���");
		btnback.setFont(new Font("���� ���", Font.PLAIN, 20));
		btnback.setBounds(335, 704, 185, 56);
		panel.add(btnback);
		btnback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new main();
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setBounds(280, 80, 1300, 850);
        	}
        });
		
		//�ǳڿ� �߰�
		panel.add(name);
		panel.add(txtname);
		panel.add(id);
		panel.add(txtid);
		panel.add(password);
		panel.add(txtpass);
		panel.add(c_password);
		panel.add(txtc_pass);
		panel.add(number);
		panel.add(txtnum);
		panel.add(email);
		panel.add(txtemail);
		panel.add(signbtn);
		panel.add(Label2);
		
		//������ ũ�� �� ��ġ
        setBounds(280, 80, 1300, 850);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷� ����
		setContentPane(panel);
		
		

		
		
	}
	  
	
}
