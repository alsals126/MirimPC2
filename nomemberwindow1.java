package GUIDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import java.awt.Color;

public class nomemberwindow1 extends JFrame{

	private JPanel contentPane;
	private static String temporarycode;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nomemberwindow1 frame = new nomemberwindow1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
    	

	public nomemberwindow1() {
		setTitle("��ȸ��");
		
		DBNomember ndb = new DBNomember();
		
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("��ȸ�� �α���");
		label.setBounds(494, 50, 338, 75);
		label.setFont(new Font("����", Font.BOLD, 45));
		
		JLabel label2 = new JLabel("�غ�ȸ�� �α����� �Ͻô� �е��� �ӽ��ڵ带 �߱��� �̿����ֽñ� �ٶ��ϴ�.��");
		label2.setBounds(392, 139, 518, 18);
		label2.setFont(new Font("����", Font.PLAIN, 15));
		
		JLabel label3 = new JLabel("�ӽ��ڵ�: ");
		label3.setBounds(356, 549, 251, 75);
		label3.setFont(new Font("����", Font.PLAIN, 25));
		
		JLabel label4 = new JLabel("*�ӽ��ڵ带 �˰� ��ž� ��ȸ�� �α����� �����մϴ�*");
		label4.setForeground(Color.RED);
		label4.setBounds(455, 490, 368, 49);
		label4.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton nobtn = new JButton("�ӽ��ڵ� �߱�");
		nobtn.setFont(new Font("����", Font.PLAIN, 38));
		nobtn.setBounds(428, 254, 404, 238);
		panel.setLayout(null);
		nobtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JTextField txtcode = new JTextField();
        		txtcode.setFont(new Font("���� ���", Font.PLAIN, 20));
				txtcode.setText(ndb.insertTemporarycode());
				//mysql�� �����ϴ� �� �˾Ƴ���
        	    txtcode.setBounds(550, 549, 251, 75);
        	    panel.add(txtcode);
        	    txtcode.setColumns(10);
        		//System.out.println();
        		
        		
        		
        	}
        	
        });
		
		


	
		//�߰�
		panel.add(label);
		panel.add(label2);
		panel.add(nobtn);
		panel.add(label3);
		panel.add(label4);
		getContentPane().add(panel);
		
		
		JButton btnback = new JButton("���ư���");
		btnback.setFont(new Font("���� ���", Font.PLAIN, 20));
		btnback.setBounds(455, 697, 185, 56);
		panel.add(btnback);
		btnback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new main();
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setBounds(280, 80, 1300, 850);
        	}
        });
		
		JButton finishbtn = new JButton("�Ϸ�");
		finishbtn.setFont(new Font("���� ���", Font.PLAIN, 20));
		finishbtn.setBounds(712, 697, 185, 56);
		panel.add(finishbtn);
		finishbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login_nomember l2 = new Login_nomember();
        		l2.main(null);
        		dispose();
        		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setBounds(280, 80, 1300, 850);
        	}
        });
		
		
		
		//������ ��ġ ũ�� ����
		 setBounds(280, 80, 1300, 850);
	       setVisible(true);
	       setResizable(false);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷� ����
	}
	
}
