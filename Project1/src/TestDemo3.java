
public class TestDemo3 {
	public static void main(String[] args){
		
		int k=0;
		for(int i=100;i<=999;i++){
			int a=i%10;
			int b=i/10%10;
			int c=i/100;
			if(a!=b&&b!=c&&c!=a){
				System.out.print(i+"\t");
				k++;
				if(k==8){
					System.out.println();
					k=0;
				}
				}
			
		}
	}

}
