package net.mindview.util;

/**
 * ʹ�÷��ͻ���BasicGenerator�������ɵ�Ϊ����CountedObject,����һ��Generator
 * ע��ʹ��Create()����ʽ�Ĺ���Generator�����ַ�ʽ
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
