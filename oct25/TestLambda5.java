package com.java8features;

@FunctionalInterface
interface MyFunctionalInterface1 {

	//A method with single parameter
    public int incrementByFive(int a);
}
public class TestLambda5 {

   public static void main(String args[]) {
        // lambda expression with single parameter num
    	MyFunctionalInterface1 f = (num) -> num-5;
        System.out.println(f.incrementByFive(22));
    }
}