package Homework;

import java.util.Scanner;

public class MyThread extends Thread{
	
	private MyClass mc;
	private boolean flag;
	private String name;
	
	
	public MyThread(boolean flag,String name,MyClass mc) {
		this.flag=flag;
		this.name=name;
		this.mc=mc;
	}
	
	public void run() {
		while(true) {
			
			if(flag) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mc.add();
			}else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mc.print();
			}
		}
	}
}
