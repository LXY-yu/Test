import java.util.Scanner;

public class TestDemo14 {
	
	public static String strInverse(String str){
		char c[]=str.toCharArray();
		for(int i=0;i<str.length()/2;i++){
			char temp=c[i];
			c[i]=c[str.length()-1-i];
			c[str.length()-1-i]=temp;
		}
		String s=String.valueOf(c);
		return s;
	}

	public static void main(String[] args) {
		System.out.println("请输入字符串");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		System.out.print("原字符串为：");
		System.out.println(str);
		System.out.print("反转后的字符串为：");
		System.out.println(strInverse(str));
	}

}
