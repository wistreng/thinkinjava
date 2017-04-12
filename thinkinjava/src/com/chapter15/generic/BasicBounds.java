package com.chapter15.generic;

interface HasColor {java.awt.Color getColor();}

class Colored<T extends HasColor>{
	T item;
	Colored(T item) {this.item = item;}
	T getItem() {return item;}
	//the bound allow you to call a method
	java.awt.Color color() {return item.getColor();}
}
class Dimension {public int x,y,z;}
/**
 * 多个边界 注意extends后面的顺序 反过来接口在前面不行
 * @author alpha
 *
 * @param <T>
 */
class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	ColoredDimension(T item) {this.item=item;}
	T getItem() {return item;}
	java.awt.Color color() {return item.getColor();}
	int getX() {return item.x;}
	int getY() {return item.y;}
	int getZ() {return item.z;}
}
/**
 * 可以继承一个类和多个接口
 * @author alpha
 *
 */
interface Weight {int weight();}
class Solid<T extends Dimension & HasColor & Weight> {
	T item;
	Solid(T item) {this.item = item;}
	T getItem() {return item;}
	java.awt.Color color() {return item.getColor();}
	int getX() {return item.x;}
	int getY() {return item.y;}
	int getZ() {return item.z;}
	int weight() {return item.weight();}
}

class Bounded extends Dimension implements HasColor,Weight {
	public java.awt.Color getColor() {return null;}
	public int weight() {return 0;}
}

public class BasicBounds {
	public static void main(String[] args){
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getX();
		solid.weight();
	}
}
