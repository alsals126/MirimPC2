package GUIDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class main extends JFrame {
	private JPanel contentPane;
	
	
	 main() {
		setTitle("�̸�PC�� � ���α׷�");
		
		JPanel mirimpc= new JPanel();
        setContentPane(mirimpc);
        
		//������ ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 80, 1300, 850);
		
		mirimpc.setBorder(new EmptyBorder(5, 5, 5, 5));
		mirimpc.setLayout(null);
		
		
		//�� ����
		JLabel label = new JLabel("�ѹ̸�PC�� ���ŰŸ� ȯ���մϴ٢�");
		label.setBounds(0, 0, 0, 0);
		mirimpc.add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("����", Font.BOLD, 35));
		
		 //��ư ����
        JButton btn1 = new JButton("ȸ��");
        btn1.setFont(new Font("�������", Font.BOLD, 45));
        mirimpc.add(btn1);
        btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Memberwindow();
        		dispose();
        	}
        });
        
        JButton btn2 = new JButton("��ȸ��");
        btn2.setFont(new Font("�������", Font.BOLD, 45));
        btn2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new nomemberwindow1();
        		dispose();
        	}
        });
        
        JButton btn3 = new JButton("ȸ������");
        btn3.setFont(new Font("�������", Font.BOLD, 25));
        btn3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new signup();
        		dispose();
        	}
        });
        
        setVisible(true);
        
        mirimpc.add(btn1);
        mirimpc.add(btn2);
        mirimpc.add(btn3);
        
        //��ư ��ġ�� ũ�� ����
        btn1.setBounds(130, 179, 400, 300);
        btn2.setBounds(750, 179, 400, 300);
        btn3.setBounds(490, 550, 300, 150);
        
        setFont(new Font("�������", Font.BOLD, 32));
        
        getContentPane().add(btn1, BorderLayout.EAST);
        getContentPane().add(btn2);
        getContentPane().add(btn3, BorderLayout.SOUTH);
        
        getContentPane().setLayout(null);
       
        
	}
	 
	public static void main(String args[]) {
		new main();
		
	}

}
