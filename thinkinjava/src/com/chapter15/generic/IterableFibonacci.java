package com.chapter15.generic;

import java.util.Iterator;

//不想重写Fibonacci类，创建一个适配器 adapter 来实现

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
	private int n;
	public IterableFibonacci(int t) { n=t; }
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() { return n>0; }
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
		for(int i:new IterableFibonacci(20))
			System.out.print(i+" ");
	}
}
