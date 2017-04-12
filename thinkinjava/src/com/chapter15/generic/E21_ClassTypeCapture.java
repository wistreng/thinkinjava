package com.chapter15.generic;

import static net.mindview.util.Print.print;

import java.util.HashMap;
import java.util.Map;

class Product {}
class ClassTypeCapture2<T> {
	Map<String,Class<?>> types =
			new HashMap<String,Class<?>>();
	public Object createNew(String typename){
		Class<?> type = types.get(typename);
		try{
			return type.newInstance();
		}catch(NullPointerException e){
			print("Not a registered typename: "+typename);
		}catch(Exception e){
			print(e.toString());
		}
		return null;
	}
	public void addType(String typename,Class<?> kind){
		types.put(typename,kind);
	}
}
public class E21_ClassTypeCapture {
	public static void main(String[] args){
		ClassTypeCapture2 ctt = new ClassTypeCapture2();
		ctt.addType("Building", Building.class);
		ctt.addType("House", House.class);
		ctt.addType("Product", Product.class);
		print(ctt.createNew("Building").getClass().getName());
		print(ctt.createNew("House").getClass().getName());
		ctt.createNew("Product");
		ctt.createNew("car");
	}
}
