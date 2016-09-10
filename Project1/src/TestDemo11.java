import java.util.Scanner;

public class TestDemo11 {

	public static void main(String[] args) {
		int a[]=new int[10];
		System.out.println("请输入数据元素:");
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<10;i++){
			a[i]=scan.nextInt();
		}
		System.out.print("数组中的元素为：{");
		for(int i=0;i<10;i++){
			System.out.print(a[i]+",");
		}
		System.out.println("}");
		System.out.print("倒序输出为：{");
		for(int i=9;i>=0;i--){
			System.out.print(a[i]+",");
		}
		System.out.println("}");

	}

}
