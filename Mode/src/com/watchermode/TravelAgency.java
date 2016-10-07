package com.watchermode;

import java.util.ArrayList;
import com.watchermode.Observer;
import com.watchermode.Subject;

public   class TravelAgency implements Subject {

	String tourStartTime;  
    String tourMess;  
    ArrayList<Observer> personList;  
    public TravelAgency() {  
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
    @Override  
    public void notfilyObserver() {  
        for (int i = 0; i < personList.size(); i++) {  
            Observer o = personList.get(i);  
            o.update(this);  
        }  
    }  
  
    public void giveMess(String time, String mess) {  
        this.tourMess = mess;  
        this.tourStartTime = time;  
        notfilyObserver();  
    }  
    public String getTourMess() {  
        return tourMess;  
    }  
    public String getTourStartTime() {  
        return tourStartTime;  
    }

}
