package com.chapter15.generic;

import java.util.*;

import net.mindview.util.*;

public class ExplicitTypeSpecification {
	static void f(Map<String,List<String>> ssl) {}
	public static void main(String[] args) {
		f(New.map());
		//�Ͼ䲻����ģ������ƶ�ֻ�Ը�ֵ������Ч
		//��������ʽ������˵�����
		f(New.<String,List<String>>map());
	}
}
