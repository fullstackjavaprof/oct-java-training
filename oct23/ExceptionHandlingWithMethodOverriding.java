package com.polymorphism;

import java.io.*;  

class Parent{  
  void msg(){
	  System.out.println("parent");
	  }  
}  
 
class ExceptionHandlingWithMethodOverriding extends Parent{  
// void msg()throws ArithmeticException{    // no error
  void msg() throws ArithmeticException {  // compile time error

    System.out.println("TestExceptionChild");  
  }  
  public static void main(String args[]){  
ExceptionHandlingWithMethodOverriding e=new ExceptionHandlingWithMethodOverriding();  
   e.msg();  
  }  
}

