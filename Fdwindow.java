package GUIDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern; //�н����峪 �̸��� Ȯ�ΰ��� ���ڿ� ���� ������ ��Ÿ���� ���� ���


public class Fdwindow extends JFrame {

	private JPanel contentPane;
	
	static final String USERNAME = "root";
	private static final String PASSWORD = "hwangyouna0415!";
	private static final String URL = "jdbc:mysql://localhost:3306/sys?characterEncoding=UTF-8&serverTimezone=UTC";


	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fdwindow frame = new Fdwindow(id);
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
	public Fdwindow(String id) {
		
	
		setTitle("���̵�ã��(��ȭ��ȣ)");
		setBounds(700, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ã���ô� ID�� " + id + "�Դϴ�.");
		lblNewLabel.setBounds(40, 80, 363, 55);
		lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		
		
	
		
		
	

	}
}
