
public class TestDemo15 {

	public static void main(String[] args) {
		String str = "1:����,2:����,3:����";
		String a[] = str.split(",");
		for(int i=0;i<a.length;i++) {
		String b[] = a[i].split(":");
		System.out.println("ѧ��:" + b[0]+", ����:"+ b[1]);
		}
	}

}
