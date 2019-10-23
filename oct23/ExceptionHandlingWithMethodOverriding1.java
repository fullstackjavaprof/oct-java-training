package com.polymorphism;

import java.io.*;  
    class ParentTest{  
      void msg() throws ArithmeticException{
    	  System.out.println("parent");
    	  }  
    }  
class ExceptionHandlingWithMethodOverriding1 extends ParentTest{  
 void msg()  throws RuntimeException {
	 System.out.println("Child");
	 }
    public static void main(String args[]){  
    	ExceptionHandlingWithMethodOverriding1 e1=new ExceptionHandlingWithMethodOverriding1();  
       try{  
       e1.msg();  
       }catch(Exception e){}  
      }  
    }


