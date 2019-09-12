package com.test.contion;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 8:58
 * @Modified By:
 */
public class MyCondition2 implements Condition {
    /**
     *
     * @param conditionContext  上下文
     * @param annotatedTypeMetadata 当前对象
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println("------------------condition---------------------------");
        String[] names = conditionContext.getRegistry().getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //从上下文获取jvm运行环境参数
        String sysetm = conditionContext.getEnvironment().getProperty("os.name");
        //从上下文获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //从上下文获取registry注册表对象
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //从注册表获取bean的定义信息
        try {
            BeanDefinition red = registry.getBeanDefinition("yellow");
        }catch (Exception e){
            System.out.println("没有yellow实力的声明，开始初始化---");
            return true;
        }
        int count = registry.getBeanDefinitionCount();
        System.out.println("当前bean定义的数量："+count);
        return false;
    }
}
