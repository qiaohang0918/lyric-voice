package com.test.contion;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 9:36
 * @Modified By:
 */
public class MyClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String system = conditionContext.getEnvironment().getProperty("os.name");
        System.out.println(system);
        if(system.toLowerCase().contains("linux")){
            return true;
        }
        return false;
    }
}
