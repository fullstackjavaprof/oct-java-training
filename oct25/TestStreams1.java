package com.java8features.streams;

import java.util.*;
import java.util.stream.Stream;

public class TestStreams1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
           list.add(i);
       }
       Stream<Integer> stream = list.stream();
       stream.forEach(System.out::println);
       
    //   stream.forEach(name->System.out.println(name));


	}

}
