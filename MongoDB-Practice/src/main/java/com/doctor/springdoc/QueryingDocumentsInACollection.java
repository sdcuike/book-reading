package com.doctor.springdoc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.doctor.domain.FkApply;

/**
 * @author sdcuike
 *
 * @time 2015年12月25日 上午11:13:05
 */
public class QueryingDocumentsInACollection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/mongoDBConfig/spring-mongoDB.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);

        List<FkApply> find = mongoTemplate.find(Query.query(Criteria.where("apply_id").gt(1000).and("cost_center.type").gt(1)), FkApply.class);
        System.out.println(find.size());
        find.forEach(System.out::println);

    }

}
