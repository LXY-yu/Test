package com.bridgemode;


abstract class AbstractRoad{  
    AbstractCar aCar;  
    void run(){}  
}  
abstract class AbstractCar{  
    void run(){} 
}  
abstract class People {  
    AbstractRoad road;  
    void run() {}  
}    
class Street extends AbstractRoad{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        aCar.run();  
        System.out.println("�������ֵ���ʻ");  
    }  
}  
class SpeedWay extends AbstractRoad{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        aCar.run();  
        System.out.println("�ڸ��ٹ�·��ʻ");  
    }  
}  
class Car extends AbstractCar{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        System.out.print("С����");  
    }  
}  
class Bus extends AbstractCar{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        System.out.print("������");  
    }  
}


  
class Man extends People{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        System.out.print("���˿���");  
        road.run();  
    }  
}  
class Woman extends People{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        System.out.print("Ů�˿���");  
        road.run();  
    }  
}  

public class Test{
public static void main(String[] args){  
      
    SpeedWay speedWay1 = new SpeedWay();  
    speedWay1.aCar = new Car();  
    speedWay1.run(); 
    
    SpeedWay speedWay2 = new SpeedWay();
    speedWay2.aCar = new Bus();
    speedWay2.run();
      
    Street street1 = new Street();  
    street1.aCar = new Bus();  
    street1.run(); 
    
    Street street2 = new Street();
    street2.aCar = new Car();
    street2.run();
    
    AbstractRoad speedWay = new SpeedWay();  
    speedWay.aCar = new Car();    
    People man = new Man();  
    man.road = speedWay;  
    man.run(); 
} 
}

