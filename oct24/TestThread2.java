package com.threads;

class TestThread2 implements Runnable{  
	 public void run(){  
	  for(int i=1;i<5;i++){  
	   
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	
	    System.out.println(i);  
	  }  
	 }  
	 public static void main(String args[]){  
		 TestThread2 tr1=new TestThread2();  
		 TestThread2 tr2=new TestThread2();  
	   Thread t1=new Thread(tr1);
	   Thread t2=new Thread(tr2);
	  t1.start();  
	  t2.start();  
	 }  
	}  