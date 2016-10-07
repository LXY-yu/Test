package com.watchermode;

import java.util.ArrayList;
import com.watchermode.Observer;
import com.watchermode.Subject;

public  class WeatherStation implements Subject{
	String forecastTime, forecastMess;  
    int maxTemperature, minTemperature;  
    ArrayList<Observer> personList;  
    public WeatherStation() {  
        personList = new ArrayList<Observer>();  
    }  
  
   
    public void addObserver(Observer o) {
    	if ((o != null) && (!personList.contains(o))) {  
            personList.add(o);  
        }  
		
	}

	public void delObserver(Observer o) {
		if (o != null) {  
            personList.remove(o);  
        }
		
	}
 
    // ֪ͨ���й۲���  
    @Override  
    public void notfilyObserver() {  
        for (int i = 0; i < personList.size(); i++) {  
            Observer o = personList.get(i);  
            o.update(this);  
        }  
    }  
    /** 
     * ����Ϣ 
     *  
     * @param t 
     * @param mess 
     * @param max 
     * @param min 
     */  
    public void doForecast(String t, String mess, int max, int min) {  
        this.forecastTime = t;  
        this.forecastMess = mess;  
        this.maxTemperature = max;  
        this.minTemperature = min;  
        notfilyObserver();// ������µ���Ϣ�����֪ͨ�۲��ߺ���  
    }  
  
    public String getForecastTime() {  
        return forecastTime;  
    }  
  
    public String getForecastMess() {  
        return forecastMess;  
    }  
  
    public int getMaxTemperature() {  
        return maxTemperature;  
    }  
  
    public int getMinTemperature() {  
        return minTemperature;  
    }


	public void addObserver(java.util.Observer o) {
		// TODO Auto-generated method stub
		
	}





	
	
}
