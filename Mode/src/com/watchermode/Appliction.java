package com.watchermode;

import com.watchermode.Person;
import com.watchermode.TravelAgency;
import com.watchermode.WeatherStation;

public class Appliction {
	public static void main(String[] args) {  
        WeatherStation we=new WeatherStation();  
        TravelAgency ta=new TravelAgency();  
		Person mrLi=new Person(ta, we);  
        we.doForecast("10��", "����С��", 28, 20);  
        ta.giveMess("10��", "��ɽ������");  
        we.doForecast("11��", "��", 30, 15);  
        ta.giveMess("11��", "��ɽһ����");  
    }  

}
