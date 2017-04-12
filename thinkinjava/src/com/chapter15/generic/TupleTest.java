package com.chapter15.generic;

import net.mindview.util.*;
/*
 * tuple 元祖------多元的泛型 = 多元的类型参数化
 */
public class TupleTest {
	//meaning of these keywords
	//this
	//static
	//final
	static TwoTuple<String,Integer> f() {
		return new TwoTuple<String,Integer>("hi",47);
	}
	
	static ThreeTuple<Amphibian,String,Integer> g() {
		return new ThreeTuple<Amphibian,String,Integer>(new Amphibian("see you"),"hihihi",58);
	}
	
	public static void main(String[] args) {
		System.out.println(f());
		System.out.println(g());
	}
}
