package GUIDB;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Login_nomember extends JFrame {

	private JPanel contentPane;
	private PrintWriter writer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_nomember frame = new Login_nomember();
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
	public Login_nomember() {
		JPanel Mirimpc= new JPanel();
        setContentPane(Mirimpc);
        
		//������ ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 80, 600, 400);
		
		
		Mirimpc.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mirimpc.setLayout(null);
		
		JLabel mirimPC = new JLabel("�̸�PC");
		mirimPC.setFont(new Font("����", Font.PLAIN, 30));
		mirimPC.setBounds(14, 12, 109, 39);
		Mirimpc.add(mirimPC);
		
		JLabel label = new JLabel("\uC784\uC2DC\uCF54\uB4DC");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(120, 155, 80, 21);
		Mirimpc.add(label);
		
		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setToolTipText("");
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setBounds(208, 146, 156, 39);
		Mirimpc.add(textField);
		textField.setColumns(10);
		
		JButton backbutton = new JButton("���ư���");
		backbutton.setFont(new Font("����", Font.PLAIN, 17));
		backbutton.setBounds(463, 12, 105, 33);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ó������ ���ư���
			}
		});
		Mirimpc.add(backbutton);
		
		JButton confrimbutton = new JButton("Ȯ��");
		confrimbutton.setFont(new Font("����", Font.PLAIN, 18));
		confrimbutton.setBounds(378, 149, 105, 33);
		confrimbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBNomember nl1 = new DBNomember();
				int num = nl1.setTemcode(textField.getText());
				
				if(num == 0) {
					try { //id.txt�� �ӽ��ڵ���̵� �Է�
			            writer = new PrintWriter(new BufferedWriter(new FileWriter("id.txt")));
			            writer.write(textField.getText());
			            writer.close();
			        } catch(Exception ex) {
			        	 new newWindow();
			        	//ó������ ���ư���
			        }
					Seat s1 = new Seat();
					s1.main(null);
					dispose();
				}else if(num == 1 ) {
					textField.setText("�ٽ� �Է����ּ���");
					textField.setFont(new Font("����", Font.PLAIN, 18));
				}				
			}
		});
		Mirimpc.add(confrimbutton);
	}
}

class newWindow extends JFrame {
    newWindow() {
        setTitle("ERROR");
        // ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
        // �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        
        JLabel NewLabel = new JLabel("�����ڿ��� �����ϼ���");
        
        NewWindowContainer.add(NewLabel);
        
        setBounds(280, 80, 1300, 850);
        //setResizable(false);
        //setVisible(true);
    }
}