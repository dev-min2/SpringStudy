package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker = null;
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("�Ｚ TV�� Ŵ");
		speaker.on();
	}
}