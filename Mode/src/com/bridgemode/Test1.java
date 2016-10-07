package com.bridgemode;

abstract class AbstractColor{
	void keep(){}
}
abstract class AbstractPet{
	AbstractColor aColor;
	void keep(){}
}
abstract class AbstractPeople{
	AbstractPet aPet;
	void keep(){}
}

class Black extends AbstractColor{
	void keep(){
		super.keep();
		System.out.print("黑色的");
	}
}
class White extends AbstractColor{
	void keep(){
		super.keep();
		System.out.print("白色的");
	}
}

class Dog extends AbstractPet{
	void keep(){
		super.keep();
		aColor.keep();
		System.out.print("狗");
	}	
}
class Cat extends AbstractPet{
	void keep(){
		super.keep();
		aColor.keep();
		System.out.print("猫");
	}
}

class WhitePeople extends AbstractPeople{
	void keep(){
		super.keep();
		System.out.print("白人养");
		aPet.keep();
	}
}
class BlackPeople extends AbstractPeople{
	void keep(){
		super.keep();
		System.out.print("黑人养");
		aPet.keep();
	}
}
class YellowPeople extends AbstractPeople{
	void keep(){
		super.keep();
		System.out.print("黄种人养");
		aPet.keep();
	}
}
public class Test1 {

	public static void main(String[] args) {
		AbstractPet pet1=new Dog();
		pet1.aColor=new White();
		AbstractPeople people1=new YellowPeople();
		people1.aPet=pet1;
		people1.keep();
		System.out.println();
		
		AbstractPet pet2=new Cat();
		pet2.aColor=new Black();
		AbstractPeople people2=new WhitePeople();
		people2.aPet=pet2;
		people2.keep();

	}

}
