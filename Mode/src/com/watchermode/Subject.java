package com.watchermode;

import com.watchermode.Observer;

/*
 * ����
 */
public interface Subject {
	 public void addObserver(Observer o);//��ӹ۲���  
	 public void delObserver(Observer o);//�Ƴ��۲���  
	 public void notfilyObserver(); 

}
