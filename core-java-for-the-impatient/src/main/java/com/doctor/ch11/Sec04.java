package com.doctor.ch11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author sdcuike
 *
 * @time 2015年10月24日 下午10:35:40
 */
public class Sec04 {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Point point = new Point();
		point.x = 11;
		point.y = 12;
		Rectangle rectangle = new Rectangle();
		rectangle.height = 22;
		rectangle.width = 66;
		rectangle.topLeft = point;

		System.out.println(point);
		System.out.println(rectangle);

		System.out.println(ToStrings.toString(point));
		System.out.println(ToStrings.toString(rectangle));
	}

	public static class ToStrings {
		public static String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {
			if (obj == null) {
				return "NULL";
			}

			Class<? extends Object> cl = obj.getClass();
			ToString ts = cl.getAnnotation(ToString.class);
			if (ts == null) {
				return obj.toString();
			}

			StringBuilder result = new StringBuilder();
			if (ts.includeName()) {
				result.append(cl.getName());
			}

			result.append("[");

			boolean first = true;

			Field[] declaredFields = cl.getDeclaredFields();
			for (Field field : declaredFields) {
				ToString toString = field.getAnnotation(ToString.class);
				if (toString != null) {
					if (first) {
						first = false;
					} else {
						result.append(",");
					}

					field.setAccessible(true);
					if (toString.includeName()) {
						result.append(field.getName());
						result.append("=");
					}

					result.append(ToStrings.toString(field.get(obj)));
				}
			}

			result.append("]");
			return result.toString();
		}
	}

	@ToString(includeName = false)
	public static class Point {
		@ToString(includeName = false)
		private int x;

		@ToString(includeName = false)
		private int y;

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	@ToString
	public static class Rectangle {
		@ToString(includeName = false)
		private Point topLeft;

		@ToString
		private int width;
		@ToString
		private int height;

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}

	@Target({ ElementType.FIELD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface ToString {
		boolean includeName() default true;
	}
}
