package GUIDB;

import java.util.Scanner;

public class PaymentExcode {
	private int card; 
	private int money;
	
	Scanner scan = new Scanner(System.in);
		
	//��������
	private int inputamount;		//���Աݾ�	 -> ������ 
	private int returnamount;		//��ȯ�ݾ�	 -> �Ž�����
	
	//getter and setter
	public void setCard() {
		this.card = card;
	}
	public int getCard() {
		return card;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}

	//����
	boolean payment = true;
	
	//��������
//	public void setPayment(int result) {
//		
//		System.out.println("---------------------------------------------");
//		System.out.println("<����>");
//		System.out.println("1.ī��    2.����   3.���");
//		System.out.print("��ȣ�Է� : ");
//		int num = scan.nextInt();		//���� ���� �Է�
//		switch(num) {		
//			case 1:
//				setCardpayment(result);		//ī��
//				break;
//			case 2:
//				setMoneypayment(result);	//����
//				break;
//			case 3:
//				Pcroom p1 = new Pcroom();   //ó������
//				p1.main(null);   
//				break;
//			default:
//				System.out.println("�ٽ��Է��ϼ���"); //�ٽ��Է�
//				setPayment(result);
//				break;
//		}
//		PaymentExcode.Exit();			//������������ �̵�
//			payment = false;
//	}
	
//	//ī����� �޼���	
//	public void setCardpayment(int result) {
//		System.out.println("---------------------------------------------");
//		System.out.println("<ī�����>");	
//		System.out.println("1.����  2.���");
//		System.out.println("���� �ݾ� " + result + "�� �Դϴ�");		//�����ݾ�		
//		System.out.print("��ȣ�� �Է��ϼ��� : ");		
//		int cardnum = scan.nextInt();			//ī����� �Է�
//		switch(cardnum) {
//			case 1:
//				setcountdown(); break;
//			case 2:	
//				Pcroom p1 = new Pcroom();
//				p1.main(null);   break;
//			default:
//				System.out.println("�ٽ��Է��ϼ���");	//�������������̵�
//				break;
//		}
//	}
	
	//���ݰ��� �޼���
	public void setMoneypayment(int resultmoney) {
		
//		System.out.println("---------------------------------------------");
//		System.out.println("<���ݰ���>");
//		System.out.println("1.����  2.���");
//		System.out.print("��ȣ�� �Է��ϼ��� : ");
//		int cashpayment = scan.nextInt();		//���ݰ��� �Է�
//		
//		switch(cashpayment) {
//			case 1:
//				System.out.println("");
//				System.out.print("���Աݾ��� �Է��ϼ��� : ");		
//				inputamount = scan.nextInt();		//�������Է�
//				System.out.println("");
//				
//				if(inputamount >= result) {	
//					System.out.println("���� �ݾ���" + result + "�� �Դϴ�");	//�����ҵ�
//					setChange(result);
//					System.out.println(toString());	//��ȯ�ݾ�->�Ž�����
//					setcountdown();
//				}else
//					System.out.println("�ܾ��� �����մϴ�");
//				
//				setMoneypayment(result);
//				break;
////			case 2:
////				Pcroom p1 = new Pcroom();
////				p1.main(null);   break;
//			default:
//				System.out.println("�ٽ��Է��ϼ���");	//������������ �̵�
//				break;
//		}
//		PaymentExcode.Exit();
//		payment = false;
	}
	
	//�Ž����� �޼���
	public int Change(int timemoney, int inputmoney) {
		int resultmoney = inputmoney-timemoney; //�Ž�����
		
		return resultmoney;
	}
//	public void setChange(int result) {
//		returnamount = inputamount - result;	//�Ž����� = �Է��Ѱ� - �����ݾ�
//	}
	//��ȯ�ݾ� �������̵�
	@Override
	public String toString() {
		return "�Ž������� " + returnamount + "�� �Դϴ�";	
	}
	
	public void setcountdown() {
		
	//ī��Ʈ�ٿ�
		System.out.println("\n<����>");
		System.out.println("*5�ʵ� �ڵ����� �ʱ�ȭ������ ���ư��ϴ�");
			for(int i=5; i>=0; i--) {
				
				for(long j=0; j<=2099999999; j++) {
					
				}//for
				
				for(long j=0; j<=2099999999; j++) {
					
				}//for
				
				System.out.println(i);
			}//for i
			
			System.out.println("������ �Ϸ�Ǿ����ϴ�. �����մϴ�   ");
			System.out.println("");
//			Pcroom a = new Pcroom();	//���� ��ü �ҷ���
//			a.main(null);	//����ȭ������
	}
			
	//����
	static void Exit() {
		System.exit(0);
	}

}