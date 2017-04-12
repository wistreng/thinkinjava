package com.chapter15.generic;

import net.mindview.util.*;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CountedObject> gen = 
			BasicGenerator.create(CountedObject.class);
		for(int i=0;i<5;i++)
			System.out.println(gen.next());
		
		//用显式的方法实现
		Generator<CountedObject> gen1 =
				new BasicGenerator<CountedObject>(CountedObject.class);
		for(int i=0;i<6;i++)
			System.out.println(gen1.next());
	}
	
	
}
