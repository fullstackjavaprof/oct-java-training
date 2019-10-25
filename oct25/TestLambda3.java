package com.java8features;

public class TestLambda3 {

	public static void main(String[] args) {
	   Thread t=new Thread(() -> System.out.println("this is in TestLambda3 class"));	
	   t.start();
	}


}
