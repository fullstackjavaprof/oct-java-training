package com.java8features;

import java.util.List;
import java.util.ArrayList;
public class TestLambda8ListIterate {
	public static void main(String[] argv) {
		List<String> names = new ArrayList<String>();
		names.add("Ajay");
		names.add("Ben");
		names.add("Cathy");
		names.add("Dinesh");
		names.add("Tom");
		
		/* Iterate without using Lambda
		 Iterator iterator = names.iterator();
		 while (iterator.hasNext()) {
			System.out.println(iterator.next());
		 } 
		*/ 
		
	//	 names.forEach((name)->System.out.println(name));
		 
		names.forEach(name->System.out.println(name));
	}
}