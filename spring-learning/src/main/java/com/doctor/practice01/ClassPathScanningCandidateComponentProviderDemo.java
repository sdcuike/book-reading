package com.doctor.practice01;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月11日 下午10:56:43
 */
public class ClassPathScanningCandidateComponentProviderDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
        String basePackage = "com/doctor";
        Set<BeanDefinition> components = provider.findCandidateComponents(basePackage);
        for (BeanDefinition component : components) {
            System.out.printf("Component: %s\n", component.getBeanClassName());
        }

    }

}
