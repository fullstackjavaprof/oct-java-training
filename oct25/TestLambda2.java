package com.java8features;

public class TestLambda2 {

	public static void main(String[] args) {
	   Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("This is in TestLambda2 class");
			
		}
	});	
	   t.start();
	}
}
