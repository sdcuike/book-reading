package com.doctor.ch04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 上午11:33:17
 */
public class Sec01 {

	public static void main(String[] args) {
		// Anonymous Subclasses
		// Just as you can have an anonymous class that implements an interface, you can have an
		// anonymous class that extends a superclass. This can be handy for debugging:
		ArrayList<String> list = new ArrayList<String>(100) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(String e) {
				boolean r = super.add(e);
				if (r) {
					System.out.println("Adding " + e);
				}
				return r;
			}
		};

		list.add("name");// Adding name

		// double brace initialization
		// 注意 double brace ，外层braces 初始化一个上下文匿名类，内层大括号是初始化代码块。
		// 这个初始化技巧不被推荐使用。缺点:语法歧义，效率低，equals方法表现奇怪（依据equals的实现）
		List<String> list2 = new ArrayList<String>() {
			{
				add("doctor");
				add("who");
			}
		};

	}
}
