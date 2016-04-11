package com.doctor.practice01;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.MethodInvoker;

/**
 * @author sdcuike
 *
 *         Created on 2016年4月11日 下午11:22:03
 */
public class ClassPathScanningCandidateComponentProviderExtendDemo {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ITestAnnotation iTestAnnotation = new ITestAnnotation() {

            @Override
            public void test() {
                System.out.println("test test");

            }
        };
        ClassPathScanningCandidateComponentProviderExtend provider = new ClassPathScanningCandidateComponentProviderExtend(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(TestAnnotation.class));
        String basePackage = "com/doctor";
        Set<ScannedGenericBeanDefinition> components = provider.findCandidateComponents(basePackage);
        for (ScannedGenericBeanDefinition component : components) {
            System.out.printf("Component: %s\n", component.getBeanClassName());
            System.out.println(component.getMetadata().getAnnotationTypes());
            Class<?> classT = Class.forName(component.getBeanClassName());

            Set<MethodMetadata> annotatedMethods = component.getMetadata().getAnnotatedMethods("com.doctor.practice01.TestAnnotation");
            for (MethodMetadata methodMetadata : annotatedMethods) {
                System.out.println(methodMetadata.getMethodName());
                System.out.println(methodMetadata.getDeclaringClassName());
                System.out.println(methodMetadata.getReturnTypeName());
                System.out.println(methodMetadata.getAnnotationAttributes("com.doctor.practice01.TestAnnotation"));
                MethodInvoker methodInvoker = new MethodInvoker();
                methodInvoker.setTargetMethod(methodMetadata.getMethodName());
                methodInvoker.setTargetObject(iTestAnnotation);
                methodInvoker.prepare();
                methodInvoker.invoke();
            }

        }

    }

}
