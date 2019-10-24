package com.java8features;

@FunctionalInterface 
interface Interface1{  

    void showMsg(String msg);   // abstract method  
    // It can contain any number of Object class methods.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
    
    default void defaultMethod() {
    	System.out.println(" this is default method");
    }
    public static void staticMethod() {
    	System.out.println(" this is static method");
    }
    
    
}  
public class FunctionalInterfaceExample1 implements Interface1{  
	public void showMsg(String msg){  
        System.out.println(msg);  
    }
    public static void main(String[] args) {  
    	FunctionalInterfaceExample1 fie = new FunctionalInterfaceExample1();  
        fie.showMsg("Hello.... ");
        fie.defaultMethod();
        Interface1.staticMethod();
    }  
}  