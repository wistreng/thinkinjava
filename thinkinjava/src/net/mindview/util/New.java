package net.mindview.util;

import java.util.*;
/*
 * Utilities to simplify generic container creation
 * By using type argument inference
 */
public class New {
	public static <K,V> Map<K,V> map() {
		return new HashMap<K,V>();
	}
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	public static <T> LinkedList<T> lList() {
		return new LinkedList<T>();
	}
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
	//Examples:
	public static void main(String[] args) {
		Map<String,List<String>> sls = New.map();
		Set<String> ss = New.set();
	}
}
