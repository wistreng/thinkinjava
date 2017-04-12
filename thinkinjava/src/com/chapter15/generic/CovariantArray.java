package com.chapter15.generic;
import static net.mindview.util.Print.*;
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
public class CovariantArray {
	public static void main(String[] args){
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		try{
			fruit[0] = new Fruit();
		}catch(Exception e){ System.out.println(e); }
		try{
			fruit[0] = new Orange();
		}catch(Exception e){ System.out.println(e); }
	}
}
/* output:
java.lang.ArrayStoreException: com.chapter15.generic.Fruit
java.lang.ArrayStoreException: com.chapter15.generic.Orange
*/