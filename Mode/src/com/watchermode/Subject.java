package com.watchermode;

import com.watchermode.Observer;

/*
 * 主题
 */
public interface Subject {
	 public void addObserver(Observer o);//添加观察者  
	 public void delObserver(Observer o);//移除观察者  
	 public void notfilyObserver(); 

}
