abstract class animal{
	public double weight;
	public String color;
	public abstract void act();
	
}

class Cat extends animal{
	public Cat(double weight,String color){
		this.weight=weight;
		this.color=color;
	}
	public void act() {
		System.out.println("≈¿ ˜");
		
	}
	
}

class Dog extends animal{
	public Dog(double weight,String color){
		this.weight=weight;
		this.color=color;
	}
	public void act() {
		System.out.println("”Œ”æ");
		
	}
	
}

public class TestDemo9 {
	
	public static void main(String[] args){
		Cat cat=new Cat(5.0,"black");
		cat.act();
		Dog dog=new Dog(10.0,"white");
		dog.act();
	
	}
}
