package com.java8features;

public class TestLambda1 {

	public static void main(String[] args) {
		MyThread m=new MyThread();
		Thread t=new Thread(m);
		t.start();

	}

}
