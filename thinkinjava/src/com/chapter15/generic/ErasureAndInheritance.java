package com.chapter15.generic;

class GenericBase<T> {
	private T element;
	public void set(T arg) { arg=element; }
	public T get() { return element; } 
}

class David1<T> extends GenericBase<T> {}

class David2 extends GenericBase {}

//class David3 extends GenericBase<?>{}

public class ErasureAndInheritance {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		David2 d2 = new David2();
		Object obj = d2.get();
		d2.set(obj);
	}
}
