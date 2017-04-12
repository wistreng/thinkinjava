package com.chapter15.generic;

import java.util.*;
import com.chapter15.generic.coffee.*;
import net.mindview.util.*;

public class Generators {
	public static <T> Collection<T>
	fill(Collection<T> coll, Generator<T> gen, int n) {
		for(int i=0; i<n; i++)
			coll.add(gen.next());
		return coll;
	}
	
	public static void main(String[] args) {
		Collection<Coffee> coffee = 
			fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 6);
		for(Coffee c:coffee)
			System.out.println(c);
		Collection<Integer> flist =
			fill(new ArrayList<Integer>(), new Fibonacci(), 8);
		for(int i:flist)
			System.out.println(i);
	}
	
	//÷ÿ‘ÿfill()∑Ω∑®
	public static <T> List<T>
	fill(List<T> list, Generator<T> gen, int n) {
		for(int i=0; i<n; i++)
			list.add(gen.next());
		return list;
	}
}
