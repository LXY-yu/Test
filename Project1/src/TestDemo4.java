
public class TestDemo4 {
	public static void main(String[] args){
		char a[][]=new char[11][11];
		for(int i=0;i<6;i++){
			for(int j=0;j<11;j++){
				if(j<5-i||j>5+i)
					a[i][j]=' ';
				else if(i%2!=0){
					if(j%2==0)
						a[i][j]='*';
					else
						a[i][j]=' ';
				}
				else if(i%2==0){
					if(j%2!=0)
						a[i][j]='*';
					else
						a[i][j]=' ';	
				}
			}
		}
		for(int i=6;i<11;i++){
			for(int j=0;j<11;j++){
				a[i][j]=a[10-i][j];
			}
		}
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				System.out.print(a[i][j]);
				
			}
			System.out.println();
		}
	}

}
