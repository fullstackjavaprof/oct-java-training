package com.javatraining.basics;

  class Animal{  
	 String color="white";  
	void printColor(){
		System.out.println(color);
	}
	 Animal(){
		 System.out.println("this is in Animal class");
	}
}
  
class Dog extends Animal{  
	String color="black"; 
	Dog(){
		super();
		System.out.println("this is in Dog class");
		
	}
void printColor(){  
	System.out.println(color);//prints color of Dog class  
	super.printColor();
	}  
}  
class TestSuper1{  
	public static void main(String args[]){  
	Dog d=new Dog();  
	d.printColor();  
	}
}
