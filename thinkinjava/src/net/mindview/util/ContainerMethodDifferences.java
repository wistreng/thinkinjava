package net.mindview.util;

import java.lang.reflect.*;
import java.util.*;


/**
 * ʹ��Sets�е�difference���� ��ӡjava.util���и�������������֮�䷽���Ĳ��죬����TreeSet��Set
 * ����ʵ����Щ�ӿ� �Ĺ���
 * @author alpha
 *
 */
public class ContainerMethodDifferences {
	/**
	 * 
	 * @param type
	 * @return ��������з�����
	 */
	static Set<String> methodSet(Class<?> type){
		Set<String> result = new TreeSet<String>();
		for(Method m:type.getMethods())
			result.add(m.getName());
		return result;
	}
	/**
	 * ��ӡ����������нӿ�
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
	 * ��ӡ������֮�䷽���Ĳ��� ʵ����Щ�ӿ� ��
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
		//�鿴11�µ�����
	}
}
