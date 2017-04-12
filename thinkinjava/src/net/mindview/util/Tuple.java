package net.mindview.util;
/**
 * ʹ�����Ͳ����ƶ� + static���� ����д֮ǰ��Ԫ�鹤��
 * @author alpha
 *
 */
public class Tuple {
	public static <A,B> TwoTuple<A,B> tuple(A a,B b) {
		return new TwoTuple<A,B>(a,b);
	}
	public static <A,B,C> ThreeTuple<A,B,C> tuple(A a,B b,C c){
		return new ThreeTuple<A,B,C>(a,b,c);
	}
	public static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a,B b,C c,D d){
		return new FourTuple<A,B,C,D>(a,b,c,d);
	}
}
