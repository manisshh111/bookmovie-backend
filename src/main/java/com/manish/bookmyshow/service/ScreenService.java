package com.manish.bookmyshow.service;

import com.manish.bookmyshow.model.Screen;

public interface ScreenService {
	
	public Screen createScreen(Screen screen);
	
	public Screen updateScreen(Long id, Screen screen);
	
	public Screen deleteScreen(Long id);
	
	public Screen findScreenByID(Long id);
	
	public Screen findScreenByName(String name);
	
}
