package com.polymorphism;

public class TryCatchExample2 {  
	  
    public static void main(String[] args) {  
    	 int data=0;
    	 String sname=null;
    	 String s="abc"; 
		
			try {
				int i=Integer.parseInt(s);
				System.out.println(sname.length());
				data = 50/0;
			}catch (ArithmeticException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
    	 System.out.println("value "+data);
    }   
}