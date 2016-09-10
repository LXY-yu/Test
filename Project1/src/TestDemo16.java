
public class TestDemo16 {

	public static void main(String[] args) {
		String str="edcfaivobspuiodjmvajczbloap";
		char c[]=str.toCharArray();
		int count=0;
		for(int i=0;i<str.length();i++){
			if(c[i]=='a')
				count++;
		}
		System.out.println("字符‘a’出现的次数为："+count);

	}

}
