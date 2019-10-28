package com.Students ;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


//多线程显示系统时间
public class MyThread extends Thread{
	
	private JLabel lblNewLabel;
//	private String sdf;

	public MyThread(JLabel lblNewLabel) {
		this.lblNewLabel=lblNewLabel;
	}
	
	public void run() {
		while(true) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(date);
		lblNewLabel.setText(str);
		}
	}
}
