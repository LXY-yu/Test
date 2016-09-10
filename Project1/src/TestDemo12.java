import java.util.Scanner;

public class TestDemo12 {

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
		System.out.println();
		for(int j=0;j<a.length-1;j++){
		for(int i=0;i<a.length-1-j;i++){
			if(a[i]>a[i+1]){
				int temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
			}
		}
		}
		System.out.print("排序后的数据为：{");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");	
		}
		System.out.println("}");
	}

}
