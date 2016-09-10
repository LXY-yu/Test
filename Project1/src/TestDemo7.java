class Car{
	private String brand;
	private String color;
	private String model;
	private double speed;
	
	public Car(){}
	public Car(String brand,String color,String model,double speed){
		this.brand=brand;
		this.color=color;
		this.model=model;
		this.speed=speed;
	}
	
	public void setBrand(String brand){
		this.brand=brand;
	}
	public void setColor(String color){
		this.color=color;
	}
	public void setModel(String model){
		this.model=model;
	}
	public void setSpeed(double speed){
		this.speed=speed;
	}
	public String getBrand(){
		return this.brand;
	}
	public String getColor(){
		return this.color;
	}
	public String getModel(){
		return this.model;
	}
	public double getSpeed(){
		return this.speed;
		
	}
	
	public void Upspeed(){
		this.speed+=10;
	}
	public void Downspeed(){
		if(this.speed-10<0){
			System.out.println("�޷�����");
		}
		else this.speed-=10;
	}
	
	public String printInfo(){
		return "Ʒ��Ϊ��"+this.brand+" ��ɫΪ��"+this.color+" �ͺ�Ϊ��"+this.model+" �ٶ�Ϊ��"+this.speed+"km/h";
	}
}
public class TestDemo7 {

	public static void main(String[] args) {
		Car car=new Car("Volkswagen","golden","JN11512",120.0);
		System.out.println(car.printInfo());
		car.Upspeed();
		System.out.println("���ٺ���ٶ�Ϊ��"+car.getSpeed()+"km/h");
		car.Downspeed();
		System.out.println("���ٺ���ٶ�Ϊ��"+car.getSpeed()+"km/h");
		

	}

}
