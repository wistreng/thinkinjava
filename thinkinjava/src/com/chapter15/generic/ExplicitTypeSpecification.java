package com.chapter15.generic;

import java.util.*;

import net.mindview.util.*;

public class ExplicitTypeSpecification {
	static void f(Map<String,List<String>> ssl) {}
	public static void main(String[] args) {
		f(New.map());
		//上句不编译的，类型推断只对赋值操作有效
		//下面用显式的类型说明解决
		f(New.<String,List<String>>map());
	}
}
