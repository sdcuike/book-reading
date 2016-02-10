package com.doctor.practice01;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sdcuike
 *
 * @time 2016年2月10日 下午9:49:16
 * 
 *       Auto-Wiring All Beans of Compatible Type
 * 
 * 
 */
public class AutoWiringAllBeansOfCompatibleType {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.doctor.practice01");
        applicationContext.refresh();
        TypeHandlerUtil typeHandlerUtil = applicationContext.getBean(TypeHandlerUtil.class);
        List<TypeHandler> typeHandlers = typeHandlerUtil.getTypeHandlers();
        typeHandlers.forEach(System.out::println);
        // com.doctor.practice01.SqlTimestampTypeHandler@7a3d45bd
        // com.doctor.practice01.StringTypeHandler@1e7c7811

        typeHandlerUtil.getTypeHandlerMap().forEach((k, v) -> System.out.println("k:" + k + " v:" + v));

        // k:Timestamp v:com.doctor.practice01.SqlTimestampTypeHandler@7a3d45bd
        // k:String v:com.doctor.practice01.StringTypeHandler@1e7c7811

    }
}
