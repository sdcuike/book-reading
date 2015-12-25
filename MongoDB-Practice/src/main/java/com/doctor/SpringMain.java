package com.doctor;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.doctor.domain.FkApply;

/**
 * @author sdcuike
 *
 * @time 2015年12月24日 下午3:08:51
 */
public class SpringMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/mongoDBConfig/spring-mongoDB.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
        List<FkApply> list = mongoTemplate.findAll(FkApply.class);
        System.out.println(list.size());
        list.forEach(System.out::println);

    }

}
