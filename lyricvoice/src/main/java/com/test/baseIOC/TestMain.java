package com.test.baseIOC;

import com.test.config.BeanConfig;
import com.test.config.FilterConfig;
import com.test.config.ImportConfig;
import com.test.pojo.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 8:16
 * @Modified By:
 */
public class TestMain {

    @Test
    public void testConfig(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");
        System.out.println("context ----- inited------- ");
        Object bean = context.getBean("user");
        User bean1 = context.getBean(User.class);
        System.out.println("bean:"+bean);
        System.out.println("bean1:"+bean1);
        System.out.println(bean==bean1);
    }


    @Test
    public void testJavaConfiguar(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        String system = context.getEnvironment().getProperty("os.name");
        System.out.println(system);
        Object red = context.getBean("red");
        Object green = context.getBean("green");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(red);
        System.out.println(green);
    }

    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        String system = context.getEnvironment().getProperty("os.name");
        System.out.println(system);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object yellow = context.getBean("yellow");
        Object yellow2 = context.getBean("yellow");
        System.out.println(yellow==yellow2);
    }


    @Test
    public void testClassCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FilterConfig.class);
        System.out.println("context------inited------------");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testIOC_BeanFilter(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FilterConfig.class);
        System.out.println("context------inited------------");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testImportBeanToContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }



}
