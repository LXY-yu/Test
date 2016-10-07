package com.watchermode;

import com.watchermode.Person;
import com.watchermode.TravelAgency;
import com.watchermode.WeatherStation;

public class Appliction {
	public static void main(String[] args) {  
        WeatherStation we=new WeatherStation();  
        TravelAgency ta=new TravelAgency();  
		Person mrLi=new Person(ta, we);  
        we.doForecast("10号", "阴有小雨", 28, 20);  
        ta.giveMess("10日", "黄山两日游");  
        we.doForecast("11号", "晴", 30, 15);  
        ta.giveMess("11日", "华山一日游");  
    }  

}
