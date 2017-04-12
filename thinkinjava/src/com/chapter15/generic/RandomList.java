package com.chapter15.generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/*
 * A generic RandomList
 * 
 */
public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(45);
	public void add(T item) { storage.add(item); }
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
	//T = String type
	public static void main(String[] args){
		RandomList<String> rs = new RandomList<String>();
		for(String s:("big brown fox run over fast "+"brown hung dog run slow").split(" "))
			rs.add(s);
		for(int i=0; i<=10; i++)
			System.out.println(rs.select());
		System.out.println("-------------------");
		
		RandomList<Date> rsd = new RandomList<Date>();
		
	}
}
