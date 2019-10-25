package com.java8features;

// Using predefined functional interface 

import java.util.function.IntBinaryOperator;

public class TestLambda7 {

   public static void main(String args[]) {
        // lambda expression
	//   IntBinaryOperator sum = (a, b) -> a - b; 
	   IntBinaryOperator sum = (a, b) -> {return (a * b);};
        System.out.println("Result: " + sum.applyAsInt(12, 100));
	   
	  
    }
}
