package com.doctor;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctor.domain.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 上午11:38:21
 */
public class MongoApp {

    public static void main(String[] args) throws UnknownHostException {
        // MongoOperations mongoTemplate = new MongoTemplate(new MongoClient(), "sdcuike");
        MongoCredential mongoCredential = MongoCredential.createCredential("mongo", "sdcuike", "mongo".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017), Arrays.asList(mongoCredential));

        MongoOperations mongoTemplate = new MongoTemplate(mongoClient, "sdcuike");
        mongoTemplate.insert(new Person("doctor", 1236666, UUID.randomUUID().toString()));
        List<Person> list = mongoTemplate.findAll(Person.class);

        System.out.println(list.size());
        list.forEach(System.out::println);
        // mongoTemplate.dropCollection(Person.class);

    }

}
