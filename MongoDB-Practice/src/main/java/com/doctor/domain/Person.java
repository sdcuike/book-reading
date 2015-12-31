package com.doctor.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 下午2:34:13
 */
public class Person {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String id;
    private String name;
    private int age;
    private Date birth = new Date();

    public Person(String name, int age, String id) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAge(int age) {
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

        return "Person [id=" + id + ", name=" + name + ", age=" + age + ",birth=" + sdf.format(birth) + "]";
    }

}
