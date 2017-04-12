package com.chapter15.generic;
/**
 * ���͵�ʵ����  �����Ѿ��й��췽������ Java�����Զ������޲εĹ��췽�� no-arg
 * @author alpha
 *
 * @param <T>
 */
class ClassAsFactory<T> {
	T x;
	public ClassAsFactory(Class<T> kind){
		try{
			x=kind.newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
}
class Employee{}
public class InstantiateGenericType {
	public static void main(String[] args){
		ClassAsFactory<Employee> ee = new ClassAsFactory<Employee>(Employee.class);
		System.out.println("new instance of Employee succeeded!");
		try{
			ClassAsFactory<Integer> ii = new ClassAsFactory<Integer>(Integer.class);
		}catch(Exception e){
			System.out.println("failed to create newinstance of ClassAsFactory<Integer>");
		}
	}
}
