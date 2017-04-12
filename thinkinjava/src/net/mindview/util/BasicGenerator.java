package net.mindview.util;

/**
 * 使用泛型化得BasicGenerator，很轻松的为对象CountedObject,创建一个Generator
 * 注意使用Create()和显式的构造Generator的两种方式
 * @author alpha
 *
 */
public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type) {this.type = type;}
	public T next() {
		try {
			//assume type is a public class
			return type.newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<>(type);
	}
}
