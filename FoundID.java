package GUIDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern; //�н����峪 �̸��� Ȯ�ΰ��� ���ڿ� ���� ������ ��Ÿ���� ���� ���


public class FoundID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private PrintWriter writer;
	
	 String email ; //�̸���
	 String number; //��ȭ��ȣ
	
	
	static final String USERNAME = "root";
	private static final String PASSWORD = "hwangyouna0415!";
	private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundID frame = new FoundID();
					frame.setVisible(true);
						
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Got an exception!");
				    System.err.println(e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FoundID() {
		
		setTitle("���̵�ã��â");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel label = new JLabel("���̵� ã��");
		label.setBounds(515, 107, 248, 63);
		label.setFont(new Font("�������", Font.BOLD, 45));
		panel.add(label);
		getContentPane().add(panel);
		
		JLabel Label = new JLabel("��ȭ��ȣ");
		Label.setBounds(293, 303, 156, 48);
		Label.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(Label);
		
		JLabel Label2 = new JLabel("�̸���");
		Label2.setBounds(293, 457, 118, 33);
		Label2.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(Label2);
		
		textField = new JTextField(); //��ȭ��ȣ
		textField.setBounds(463, 303, 397, 54);
		textField.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField1 = new JTextField(); //�̸���
		textField1.setBounds(463, 449, 397, 54);
		textField1.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(textField1);
		textField1.setColumns(10);
		
		
		
		
		
		JButton btn1 = new JButton("Ȯ��"); //��ȭ��ȣ Ȯ�� ��ư
		btn1.setBounds(897, 282, 128, 97);
		btn1.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		FoundidDB f1 = new FoundidDB();
        		String id = f1.foundID(textField.getText());
        		
        		
        		Fdwindow fd = new Fdwindow(id);
        		fd.main(id);
        		
        		new Memberwindow();
        		dispose();
        		
        	
        		
        	}
        });
		
					
		JButton btn2 = new JButton("Ȯ��"); //�̸��� Ȯ�� ��ư
		btn2.setBounds(897, 440, 128, 97);
		btn2.setFont(new Font("���� ���", Font.PLAIN, 35));
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	FoundidDB f1 = new FoundidDB();
        		String id = f1.foundID2(textField1.getText());
        		
        		Fdwindow fd = new Fdwindow(id);
        		fd.main(id);
        		
        		new Memberwindow();
        		dispose();
        		
	        	}
	        });
		
		
		JLabel Label3 = new JLabel("�� ��ȭ��ȣ �Ǵ� �̸����� �Է��Ͻø� ���̵� ã�� ����� �̿��Ͻ� �� �ֽ��ϴ�.��");
		Label3.setBounds(349, 182, 615, 26);
		Label3.setFont(new Font("���� ���", Font.PLAIN, 16));
		Label3.setForeground(Color.red);
		panel.add(Label3);
		
		JButton btnback = new JButton("���ư���");
		btnback.setFont(new Font("���� ���", Font.PLAIN, 20));
		btnback.setBounds(542, 637, 185, 56);
		panel.add(btnback);
		btnback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new main();
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setBounds(280, 80, 1300, 850);
        	}
        });
		
		
	
		 setBounds(280, 80, 1300, 850);
	     setVisible(true);
	     setResizable(false);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷� ����
		
			
	}
	
}
