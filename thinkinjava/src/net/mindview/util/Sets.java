package net.mindview.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	//A or B
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	//A and B
	public static <T> Set<T> intersection(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(a);
		return result;
	}
	//A - B (A include B)
	public static <T> Set<T> difference(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.removeAll(b);
		return result;
	}
	
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return difference(union(a, b), intersection(a, b));
	}
}
