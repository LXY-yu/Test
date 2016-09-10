class People{
	private String name;
	private int age;
	private char sex;
	private double weight;
	
	public  People(){}
	
	public People(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public People(String name,int age,char sex,double weight){
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.weight=weight;
		
	}
	
	public void setname(String name){
		this.name=name;
	}
	public void setage(int age){
		this.age=age;
	}
	public void setsex(char sex){
		this.sex=sex;
	}
	public void setweighet(double weight){
		this.weight=weight;
	}
	
	public String getname(){
		return this.name;
	}
	public int getage(){
		return this.age;
	}
	public char getsex(){
		return this.sex;
	}
	public double getweight(){
		return this.weight;
	}
	
	public String printInfo(){
		return "姓名为"+this.name+"，年龄为"+this.age+"，性别为"+this.sex+"，体重为"+this.weight;
	}
}


public class TestDemo6 {

	public static void main(String[] args) {
		People people=new People("Chenyu Hua",26,'男',55.0);
		people.setweighet(59.9);
		System.out.println(people.printInfo());
	}

}
