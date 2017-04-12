package net.mindview.util;

import java.lang.reflect.*;
import java.util.*;


/**
 * 使用Sets中的difference方法 打印java.util包中各种任意两种类之间方法的差异，比如TreeSet和Set
 * 还有实现哪些接口 的功能
 * @author alpha
 *
 */
public class ContainerMethodDifferences {
	/**
	 * 
	 * @param type
	 * @return 该类的所有方法名
	 */
	static Set<String> methodSet(Class<?> type){
		Set<String> result = new TreeSet<String>();
		for(Method m:type.getMethods())
			result.add(m.getName());
		return result;
	}
	/**
	 * 打印出该类的所有接口
	 * @param type
	 */
	static void interfaces(Class<?> type){
		System.out.println("Interfaces in "+type.getSimpleName()+": ");
		List<String> result = new ArrayList<>();
		for(Class<?> c:type.getInterfaces())
			result.add(c.getSimpleName());
		System.out.println(result);
	}
	static Set<String> object = methodSet(Object.class);
	static {object.add("clone");}
	/**
	 * 打印两种类之间方法的差异 实现哪些接口 等
	 * @param superset
	 * @param subset
	 */
	static void difference(Class<?> superset, Class<?> subset){
		System.out.print(superset.getSimpleName()
				+" extends "+subset.getSimpleName()
				+", adds: ");
		Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
		//Don't show 'Object' methods
		comp.removeAll(object);
		System.out.println(comp);
		interfaces(superset);
	}
	
	public static void main(String[] args){
		System.out.println("Collection: "+methodSet(Collection.class));
		System.out.println("----------Interfaces-------------");
		interfaces(Collection.class);
		System.out.println("----------Difference-------------");
		difference(Set.class,Collection.class);
		//difference(Collection.class,Set.class);
		difference(HashSet.class,Set.class);
		difference(LinkedHashSet.class, HashSet.class);
		difference(TreeSet.class, Set.class);
		//查看11章的内容
	}
}
