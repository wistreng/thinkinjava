package net.mindview.util;

import java.util.LinkedList;

public class Amphibian {
	LinkedList<String> ll = new LinkedList<String>();
	public Amphibian(String Str) {
		ll.addFirst(Str); 
	}
	
	public String toString() {
		return ll.getFirst();
	}
}
