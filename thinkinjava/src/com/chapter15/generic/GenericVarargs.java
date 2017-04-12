package com.chapter15.generic;

import java.util.*;

public class GenericVarargs {
	public static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for(T item:args)
			result.add(item);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> ls = makeList("a","b","c");
		System.out.println(ls);
		ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
}
