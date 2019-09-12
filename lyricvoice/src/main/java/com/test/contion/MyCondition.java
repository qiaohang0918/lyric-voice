package com.test.contion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 8:58
 * @Modified By:
 */
public class MyCondition implements Condition {
    /**
     *
     * @param conditionContext  上下文
     * @param annotatedTypeMetadata 当前对象
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String sysetm = conditionContext.getEnvironment().getProperty("os.name");
        if(sysetm.toLowerCase().contains("windows")){
            return true;
        }
        return false;
    }
}
