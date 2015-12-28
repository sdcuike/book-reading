package com.doctor.springdoc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.doctor.domain.Person;
import com.mongodb.WriteResult;

/**
 * @author sdcuike
 *
 * @time 2015年12月27日 下午10:54:16
 */
public class SavingUpdatingRemovingDocuments {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/mongoDBConfig/spring-mongoDB.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);

        Person person = new Person("doctorwho", 28888, "11188");
        if (mongoTemplate.findById(person.getId(), Person.class) == null) {
            mongoTemplate.insert(person);
        }

        Person findById = mongoTemplate.findById(person.getId(), Person.class);
        System.out.println(findById);

        List<Person> find = mongoTemplate.find(Query.query(Criteria.where("name").is("doctorwho").and("age").is(28888)), Person.class);
        find.forEach(System.out::println);

        WriteResult updateMulti = mongoTemplate.updateMulti(Query.query(Criteria.where("age").is(28888)), Update.update("age", 888888), Person.class);
        System.out.println(updateMulti.getN());

    }

}
