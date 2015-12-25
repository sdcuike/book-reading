package com.doctor;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctor.domain.Person;
import com.mongodb.MongoClient;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 上午11:38:21
 */
public class MongoApp {

    public static void main(String[] args) throws UnknownHostException {
        MongoOperations mongoTemplate = new MongoTemplate(new MongoClient(), "test_mongo");
        mongoTemplate.insert(new Person("doctor", 1236666, UUID.randomUUID().toString()));
        List<Person> list = mongoTemplate.findAll(Person.class);

        System.out.println(list.size());
        list.forEach(System.out::println);
        // mongoTemplate.dropCollection(Person.class);

    }

}
