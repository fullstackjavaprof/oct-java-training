package com.java8features.streams;

import java.util.*;
import java.util.stream.*;
public class TestStreams {
	
	public static void main(String[] args) {
		
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amit");
		memberNames.add("Shekhar");
		memberNames.add("Varun");
		memberNames.add("Rahul");
		memberNames.add("Shiva");
		memberNames.add("Kumar");
		memberNames.add("Vasu");
		memberNames.add("Lokesh");
		
		long totalMatched = memberNames.stream()
                			.filter((s) -> s.startsWith("V"))
                			.count();

		System.out.println(totalMatched);

	}

}
