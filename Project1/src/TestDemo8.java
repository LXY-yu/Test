import java.util.Scanner;

interface Unionpay{
	 public boolean TestPassword(String input);//�������룬��������
	 public boolean DrawMoney(double number);//ȡǮ,����ȡǮ��Ŀ
	 public double CheckBalance();//��ѯ���
}
 interface ICBC extends Unionpay{//��������
	 public void OnlinePayment(double number);//����֧��,����֧�����
	 
 }
 interface ABC extends Unionpay{//ũҵ����
	 public boolean PayPhonebills(String phoneNum,double number);//֧���绰��,����绰���뼰���
	 
 }
 
  class ICBCmpl implements ICBC{
	  double money;
	  String password;
	  public ICBCmpl(double money,String password){
		  this.money=money;
		  this.password=password;
	  }

	//��������
	public boolean TestPassword(String input) {
		if(password.equals(input))
			return true;
		else
			return false;
	}

	//ȡǮ
	public boolean DrawMoney(double number) {
		if(number<=money){
			money-=number;
			return true;
		}
			return false;
	}

	//��ѯ���
	public double CheckBalance() {
		return money;
	}

	//����֧��
	public void OnlinePayment(double number) {
		if(number<=money)
			money-=number;
		
	}
	 
 }
  
  class ABCmpl implements ABC{
	  String password;
	  double money;
	  
	  public ABCmpl(double money,String password){
		  this.money=money;
		  this.password=password;
	  }

	//��������
	public boolean TestPassword(String input) {
		if(password.equals(input))
			return true;
		else
			return false;
	}

	//ȡǮ
	public boolean DrawMoney(double number) {
		if(number<=money+2000){
			money-=number;
			return true;
		}
		return false;
	}

	//��ѯ���
	public double CheckBalance() {
		return money;
	}
	
	//�绰��֧��
	public boolean PayPhonebills(String phoneNum, double number) {
		if(phoneNum.length()==11&&number<=money+2000){
			money-=number;
			return true;
		}
		return false;
	}
	  
  }

public class TestDemo8 {

	public static void main(String[] args) {
		
		//��ҵ���е��Բ���
		Unionpay icbc = new ICBCmpl(2000,"123456");
		Scanner input = new Scanner(System.in);
        System.out.println("���������룺");
        if(icbc.TestPassword(input.next())){
            System.out.println("�������");
            double num = Double.parseDouble(input.next());
            if(icbc.DrawMoney(num)){
                System.out.println("ȡǮ�ɹ��������Ϊ��"+icbc.CheckBalance());
            }
            else{
                System.out.println("ȡǮʧ��");
            }
        }else{
            System.out.println("�������");
        }
        
        
        System.out.println("=========================================");
        
        //ũҵ���е��Բ��� 
        Unionpay abc = new ABCmpl(2000,"456789");
		Scanner input1 = new Scanner(System.in);
        System.out.println("���������룺");
        if(abc.TestPassword(input1.next())){
            System.out.println("�������");
            double num = Double.parseDouble(input1.next());
            if(abc.DrawMoney(num)){
                System.out.println("ȡǮ�ɹ��������Ϊ��"+abc.CheckBalance());
            }
            else{
                System.out.println("ȡǮʧ��");
            }
        }else{
            System.out.println("�������");
        }
		
	}

	
}
