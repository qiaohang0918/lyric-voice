package com.test.config;

import com.test.beanimport.MyImportRule;
import com.test.pojo.Blue;
import com.test.pojo.Green;
import com.test.pojo.Red;
import org.springframework.context.annotation.*;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 10:45
 * @Modified By:
 */
@Configuration
@Import(value = {Blue.class,BeanConfig.class})     //直接导入bean[Blue]   同时导入BeanConfig按条件定义的bean
@ImportResource(reader = MyImportRule.class)    //自定易规则导入bean
public class ImportConfig {

    @Lazy
    @Scope(scopeName="singleton")
    @Bean(name = "red",initMethod = "initred")
    public Red initRed(){
        return new Red();
    }


    @Scope(scopeName="prototype")
    @Bean(name = "green",initMethod = "initgreen")
    public Green initGreen(){
        return new Green();
    }
}
