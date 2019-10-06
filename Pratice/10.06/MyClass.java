package Homework;

import java.util.Scanner;

public class MyClass {
	
	private String str="China";
	private String s;
	
	
	
	public synchronized String add() {
		
		Scanner sc=new Scanner(System.in);
		s=sc.nextLine();
		
		StringBuffer sb=new StringBuffer(str);
		sb.append(s);
		str=sb.toString();
		notify();
		return str;
	}
	
	public synchronized void print() {
		if(str.equals("")) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		System.out.print("Print:"+str+"\n");
		str="";
		}
	}
	
	
	
	
	
}
