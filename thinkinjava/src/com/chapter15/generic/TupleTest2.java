package com.chapter15.generic;

import net.mindview.util.*;
import static net.mindview.util.Tuple.*;

public class TupleTest2 {
	static TwoTuple<String,Integer> f() {return tuple("hi",47);}
	static TwoTuple f2() {return tuple("hi",47);}
	
	TwoTuple<String,Integer> tt = f2();
	
	public static void main(String[] args){
		System.out.println(f());
		System.out.println(f2());
	}
}
