package com.chapter15.generic;

public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}
	
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0f);
		gm.f("A");
		gm.f(gm);
		GenericMethods.g("",1237894.1231,gm);
		GenericMethods.h("",-299,2);
	}
	/*
	 * 观察结果输出，我们看到在泛型方法中类型是自动识别，
	 * 如果是基础类型则会自动打包 
	 * this is type argument inference
	 * 类型参数推断
	 */
	
	//多个类型
	public static <A,B,C> void g(A a,B b,C c){
		System.out.println("--"+a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
	}
	
	public static <A,B> void h(A a,B b,Integer c){
		System.out.println("--"+a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
	}
	
	
}
