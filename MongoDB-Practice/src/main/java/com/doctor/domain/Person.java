package com.doctor.domain;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 下午2:34:13
 */
public class Person {

    private String id;
    private String name;
    private int age;

    public Person(String name, int age, String id) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
