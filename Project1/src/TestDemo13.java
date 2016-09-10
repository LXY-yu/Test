class Queen{
	private static final Queen INSTANCE=new Queen();
	public static Queen getInstance(){
		 return INSTANCE;
	}
	private Queen(){}
	public void print(){
		System.out.println("我是唯一的王，谢谢你们还在，我的国。");
	}
}
public class TestDemo13 {
	public static void main(String[] args){
		Queen queen=Queen.getInstance();
		queen.print();
	}

}
