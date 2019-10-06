package Homework;


public class Test {
public static void main(String[] args) {
	
	
	MyClass mc=new MyClass();
	
	MyThread mt1=new MyThread(true,"T1",mc);
	MyThread mt2=new MyThread(false,"T2",mc);
	
	mt1.start();
	mt2.start();
}
}
