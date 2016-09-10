import java.util.Scanner;

interface Unionpay{
	 public boolean TestPassword(String input);//检验密码，输入密码
	 public boolean DrawMoney(double number);//取钱,输入取钱数目
	 public double CheckBalance();//查询余额
}
 interface ICBC extends Unionpay{//工商银行
	 public void OnlinePayment(double number);//在线支付,输入支付金额
	 
 }
 interface ABC extends Unionpay{//农业银行
	 public boolean PayPhonebills(String phoneNum,double number);//支付电话费,输入电话号码及金额
	 
 }
 
  class ICBCmpl implements ICBC{
	  double money;
	  String password;
	  public ICBCmpl(double money,String password){
		  this.money=money;
		  this.password=password;
	  }

	//检验密码
	public boolean TestPassword(String input) {
		if(password.equals(input))
			return true;
		else
			return false;
	}

	//取钱
	public boolean DrawMoney(double number) {
		if(number<=money){
			money-=number;
			return true;
		}
			return false;
	}

	//查询余额
	public double CheckBalance() {
		return money;
	}

	//在线支付
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

	//检验密码
	public boolean TestPassword(String input) {
		if(password.equals(input))
			return true;
		else
			return false;
	}

	//取钱
	public boolean DrawMoney(double number) {
		if(number<=money+2000){
			money-=number;
			return true;
		}
		return false;
	}

	//查询余额
	public double CheckBalance() {
		return money;
	}
	
	//电话费支付
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
		
		//工业银行调试部分
		Unionpay icbc = new ICBCmpl(2000,"123456");
		Scanner input = new Scanner(System.in);
        System.out.println("请输入密码：");
        if(icbc.TestPassword(input.next())){
            System.out.println("请输入金额：");
            double num = Double.parseDouble(input.next());
            if(icbc.DrawMoney(num)){
                System.out.println("取钱成功，卡余额为："+icbc.CheckBalance());
            }
            else{
                System.out.println("取钱失败");
            }
        }else{
            System.out.println("密码错误");
        }
        
        
        System.out.println("=========================================");
        
        //农业银行调试部分 
        Unionpay abc = new ABCmpl(2000,"456789");
		Scanner input1 = new Scanner(System.in);
        System.out.println("请输入密码：");
        if(abc.TestPassword(input1.next())){
            System.out.println("请输入金额：");
            double num = Double.parseDouble(input1.next());
            if(abc.DrawMoney(num)){
                System.out.println("取钱成功，卡余额为："+abc.CheckBalance());
            }
            else{
                System.out.println("取钱失败");
            }
        }else{
            System.out.println("密码错误");
        }
		
	}

	
}
