package com.chapter15.generic;

import java.util.*;

/**
 * 这个例子告诉我们 计算机是如何看待泛型对象 泛型的工作原理是擦除
 * @author alpha
 *
 */
public class ErasedTypeEquivalence {
	public static void main(String[] args){
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1==c2);
	}
}
/*output:
 true
*/