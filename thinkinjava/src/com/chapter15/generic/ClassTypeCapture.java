package com.chapter15.generic;

import java.util.*;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
	private Class<T> kind;
	public ClassTypeCapture(Class<T> kind){
		this.kind = kind;
	}
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public static void main(String[] args){
		ClassTypeCapture<Building> ctc1 =
				new ClassTypeCapture<Building>(Building.class);
		ClassTypeCapture<House> ctc2 =
				new ClassTypeCapture<>(House.class);
		System.out.println(ctc1.f(new Building()));
		System.out.println(ctc1.f(new House()));
		System.out.println(ctc2.f(new Building()));//false, house is not a new instance of building
		System.out.println(ctc2.f(new House()));
	}
	//ex21 page381
//	private Map<String,Class<?>> map = new HashMap<String,Class<?>>;
//	public static void addType<String typename, Class<?> kind>(){
//		
//	}
}
