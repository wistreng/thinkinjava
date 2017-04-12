package com.chapter5.initialization;
import static net.mindview.util.Print.*;
class Tree {
	int height;
	Tree(){
		print("planting a seed!");
		height = 0;
	}
	Tree(int initHeight){
		height = initHeight;
		print("Creating new tree that is "+height+" feet tall!");
	}
	void info(){
		print("tree that is "+height+" feet tall!");
	}
	void info(String s){
		print("overloading method info: "+ s);
	}
}
public class Overloading {
	public static void main(String[] args){
		for(int i=0;i<=5;i++) {
			Tree t = new Tree(i);
			t.info();
			t.info("input String");
		}
		new Tree();
	}
}
