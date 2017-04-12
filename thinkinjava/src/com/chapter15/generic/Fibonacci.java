package com.chapter15.generic;

import net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer>{
	private int count = 0;
	public Integer next() { return fib(count++); }
	private Integer fib(int x) {
		if(x<2) return 1; 
		return fib(x-2) + fib (x-1);
	}
	
	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for(int i=0; i<15; i++)
			System.out.println(gen.next());
	}
}
//虽然我们参数化的是Integer类型，里面用的都是 int类型，利用的是javaSE5以后都有自动打包和拆包的功能
