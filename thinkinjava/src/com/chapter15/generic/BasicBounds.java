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
 * ����߽� ע��extends�����˳�� �������ӿ���ǰ�治��
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
 * ���Լ̳�һ����Ͷ���ӿ�
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
