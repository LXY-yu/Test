
public class TestDemo15 {

	public static void main(String[] args) {
		String str = "1:张三,2:李四,3:王五";
		String a[] = str.split(",");
		for(int i=0;i<a.length;i++) {
		String b[] = a[i].split(":");
		System.out.println("学号:" + b[0]+", 姓名:"+ b[1]);
		}
	}

}
