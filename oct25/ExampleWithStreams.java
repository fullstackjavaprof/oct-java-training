package com.java8features.streams;

import java.util.ArrayList;
import java.util.List;
public class ExampleWithStreams{ 
   public static void main(String[] args) {    
	List<String> names = new ArrayList<String>();
	names.add("Ajeet");
	names.add("rhul");
	names.add("Aditya");
	names.add("kumar");
	names.add("sekhar");
	names.add("ramu");
		
	//Using Stream and Lambda expression
	long count = names.stream()
			     .filter(str->str.length()<6)
			     .count();
	System.out.println("There are "+count+" strings with length less than 6");

   }  
}