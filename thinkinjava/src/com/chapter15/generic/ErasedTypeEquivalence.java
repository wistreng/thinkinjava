package com.chapter15.generic;

import java.util.*;

/**
 * ������Ӹ������� ���������ο������Ͷ��� ���͵Ĺ���ԭ���ǲ���
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