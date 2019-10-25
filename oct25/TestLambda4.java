package com.java8features;

@FunctionalInterface
interface MyFunctionalInterface {

	//A method with no parameter
    public String sayHello();
}
public class TestLambda4 {

   public static void main(String args[]) {
        // lambda expression
    	MyFunctionalInterface msg = () -> {
    		return "Hello";
    	};
        System.out.println(msg.sayHello());
    }
}
