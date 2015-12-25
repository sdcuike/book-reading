package com.doctor.springdoc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.doctor.domain.FkApply;

/**
 * @author sdcuike
 *
 * @time 2015年12月25日 上午11:19:21
 */
public class MapReduceOperations {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/mongoDBConfig/spring-mongoDB.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
        BasicQuery basicQuery = new BasicQuery("{apply_id:{$gt:800}}");
        List<FkApply> find = mongoTemplate.find(basicQuery, FkApply.class);
        System.out.println(find.size());
        find.forEach(System.out::println);
    }

}
