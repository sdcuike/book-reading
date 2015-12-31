package com.doctor.springdoc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.alibaba.fastjson.JSON;
import com.doctor.domain.FkApply;

/**
 * @author sdcuike
 *
 * @time 2015年12月31日 下午5:04:39
 */
public class AggregationOperations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/mongoDBConfig/spring-mongoDB.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
        BasicQuery basicQuery = new BasicQuery("{apply_id:{$gt:800}}");
        List<FkApply> find = mongoTemplate.find(basicQuery, FkApply.class);
        System.out.println(find.size());
        find.forEach(System.out::println);

        // Projection Expressions
        System.err.println("Projection Expressions");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("apply_id", "apply_type"));
        AggregationResults<OutputType> aggregate = mongoTemplate.aggregate(aggregation, "fk_qc_apply", OutputType.class);
        aggregate.forEach(System.out::println);
    }

    public static class OutputType {
        private Long apply_id;

        private Long apply_type;

        public Long getApply_id() {
            return apply_id;
        }

        public void setApply_id(Long apply_id) {
            this.apply_id = apply_id;
        }

        public Long getApply_type() {
            return apply_type;
        }

        public void setApply_type(Long apply_type) {
            this.apply_type = apply_type;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    public static class OutputType1 {
        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
