class Queen{
	private static final Queen INSTANCE=new Queen();
	public static Queen getInstance(){
		 return INSTANCE;
	}
	private Queen(){}
	public void print(){
		System.out.println("����Ψһ������лл���ǻ��ڣ��ҵĹ���");
	}
}
public class TestDemo13 {
	public static void main(String[] args){
		Queen queen=Queen.getInstance();
		queen.print();
	}

}
