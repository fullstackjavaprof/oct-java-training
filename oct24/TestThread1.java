package com.threads;

class TestThread1 extends Thread{  
	 public void run(){  
	  for(int i=1;i<5;i++){  
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
	    System.out.println(i);  
	  }  
	 }  
	 public static void main(String args[]){  
		 TestThread1 t1=new TestThread1();  
		 TestThread1 t2=new TestThread1();  
	   
	  t1.start();  
	  t2.start();  
	 }  
	}  