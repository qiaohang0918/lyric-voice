package com.test.config;

import com.test.contion.MyCondition;
import com.test.contion.MyCondition2;
import com.test.pojo.Green;
import com.test.pojo.Red;
import com.test.pojo.Yellow;
import org.springframework.context.annotation.*;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 8:41
 * @Modified By:
 */
@Configuration
public class BeanConfig {

    @Bean(name = "red")
    public Red createRed(){
        return new Red();
    }

    @Bean(name = "green")
    public Green createGreen(){
        return new Green();
    }

    /**
     * condition 提供对象创建的一些条件限制,类似与过滤器链，一层一层判断过过滤，最后满足条件则创建！
     * @return
     */
    @Scope(value = "singleton")
    @Bean(name = "yellow")
    @Conditional({MyCondition.class,MyCondition2.class})
    public Yellow initYellow(){
        return new Yellow();
    }


}
