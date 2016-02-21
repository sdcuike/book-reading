package com.doctor.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author sdcuike
 *
 * @time 2016年2月21日 上午9:47:33
 * 
 * @see https://minborgsjavapot.blogspot.com/2015/05/java-8s-functional-view-on-pojos-plain.html
 */
public class AJava8FunctionalViewOnPOJOs {

    public static void main(String[] args) {
        City city = new City("shang hai", "sh");
        // A Functional View of Getters
        // A getter is something that can take a POJO and convert it into something else. This corresponds to a Java 8 Function. In our City example, the getName() getter corresponds to a Java 8 Function<City, String> because the getter takes a City and turns it into a String. In other words it maps
        // a City to a String. We can easily prove our postulate by the following code snippet:
        Function<City, String> getNameFun = City::getName;
        Function<City, String> getCodeFun = City::getCode;

        // So, now you can use a Function instead of calling the getter directly. This can be very useful when you want to use different getters programatically in your code, for example by providing the getter as a Function in methods you call. It is also handy because it allows you to use the
        // methods programatically without resorting to reflection in some cases.
        System.out.println(getNameFun.apply(city));
        System.out.println(getCodeFun.apply(city));

        // A Functional View of Setters
        // The functional view on setters is a slightly more complex than for getters. Here we really use two parameters: the POJO itself and some value we want to set in the POJO. As opposed to a getter, we do not want to return anything. The way to go in Java 8 is to use something called a
        // BiConsumer. As its prefix implies, a BiConsumer takes two parameter and it "consumes" them both, meaning that they are "swallowed" so that nothing is returned. Again, we can test this thesis very easily like this:
        BiConsumer<City, String> setNameFun = City::setName;
        City city2 = new City();
        setNameFun.accept(city2, "Shang Hai ");
        System.out.println(city2.getName());

        // A Functional View of Constructors
        Supplier<City> defaultConstructor = City::new;
        City city3 = defaultConstructor.get();
        System.out.println(city3.getName() + city3.getCode());

        BiFunction<String, String, City> twoParameterConstructor = City::new;
        City city4 = twoParameterConstructor.apply("ShangHai01", "sh01");
        System.out.println(city4.getName() + ":" + city4.getCode());

    }

    public static class City {
        private String name;
        private String code;

        public City() {

        }

        public City(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }
}
