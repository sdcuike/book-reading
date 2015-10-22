package com.doctor.ch03;

import java.util.Objects;

/**
 * @author sdcuike
 *
 * @time 2015年10月22日 下午3:41:05
 * 
 *       Resolving Default Method Conflicts
 */
public class Sec02 {

	public static void main(String[] args) {

		// Resolving Default Method Conflicts
		Employee employee = new Employee("doctor who");

		System.out.println(employee.getName());
		System.out.println(employee.getId());

	}

	public static class Employee implements Person, Identified {
		private String name;

		public Employee(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getId() {
			return Identified.super.getId(); // The super keyword lets you call a supertype method.
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}

}
