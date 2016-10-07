package com.watchermode;

import com.watchermode.Observer;
import com.watchermode.Subject;
import com.watchermode.TravelAgency;
import com.watchermode.WeatherStation;

public class Person implements Observer{
	Subject travelSubject, weatherSubject;  
    String forecatsTime, forecastMess;  
    int maxTemp, minTemp;  
    String tourStartTime, tourMess;  
    public Person(Subject travelSubject, Subject weatherSubject) {  
        this.travelSubject = travelSubject;  
        this.weatherSubject = weatherSubject;  
        travelSubject.addObserver(this);  
        weatherSubject.addObserver(this);  
    }  
  
     
    public void update(Subject subject) {  
        if (subject instanceof WeatherStation) {  
            WeatherStation we = (WeatherStation) subject;  
            forecastMess = we.getForecastMess();  
            forecatsTime = we.getForecastTime();  
            maxTemp = we.getMaxTemperature();  
            minTemp = we.getMinTemperature();  
            System.out.println("����Ԥ��:" + forecatsTime + "," + ",����״��:"  
                    + forecastMess + ",����¶�:" + maxTemp + ",����¶�" + minTemp);  
        } else if (subject instanceof TravelAgency) {  
            TravelAgency tr = (TravelAgency) subject;  
            tourMess = tr.getTourMess();  
            tourStartTime = tr.getTourStartTime();  
            System.out.println("���ο�ʼ����:" + tourStartTime + ",������Ϣ:" + tourMess);  
        }  
    }
  

}
