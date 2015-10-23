package com.doctor.ch04;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

/**
 * @author sdcuike
 *
 * @time 2015年10月23日 下午1:47:53
 * 
 *       Loading Resources
 * 
 */
public class Sec04 {

	public static void main(String[] args) throws IOException {

		// If you place a resource into the same directory as the class file, you can open an input stream to the file like this:
		try (InputStream inputStream = Sec04.class.getResourceAsStream("")) {
			String content = IOUtils.toString(inputStream);
			System.out.println(content);//
		}
		try (InputStream inputStream = Sec04.class.getResourceAsStream("keyPoints.md")) {
			String content = IOUtils.toString(inputStream);
			System.out.println(content);
		}

		/**
		 * Resources can have subdirectories which can be relative or absolute. For example,
		 * MyClass.class.getResourceAsStream("/config/menus.txt") locates
		 * config/menus.txt in the directory that contains the root of the package to which
		 * MyClass belongs.
		 * If you package classes into JAR files, zip up the resources together with the class files,
		 * and they will be located as well.
		 */
		try (InputStream inputStream = Sec04.class.getResourceAsStream("/")) {
			String content = IOUtils.toString(inputStream);
			System.out.println(content);
		}

	}
}
