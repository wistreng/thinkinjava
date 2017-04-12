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
	 * �۲�����������ǿ����ڷ��ͷ������������Զ�ʶ��
	 * ����ǻ�����������Զ���� 
	 * this is type argument inference
	 * ���Ͳ����ƶ�
	 */
	
	//�������
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
