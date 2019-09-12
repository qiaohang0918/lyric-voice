package com.test.config;

import com.test.contion.MyClassCondition;
import com.test.custom.MyFilterType;
import com.test.pojo.Green;
import com.test.pojo.Red;
import com.test.service.MyService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 9:32
 * @Modified By:
 */
@Configuration
//@Conditional(value = {MyClassCondition.class})
@ComponentScan(basePackages = {"com.test.dao","com.test.controller","com.test.service"},excludeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class}),    //按照注解过滤。不加载拥有这些注解的实例
        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {MyService.class}), //按照指定的类型过滤，不加载这些实例
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes = {MyFilterType.class})
                            //自定义过滤，不加载某些实例（实现FilterType接口，重写方法中提供了MetadataReader对象，可以获取当前元数据(.class)相关信息(resource/annnotation...)）
})
public class FilterConfig {

    @Bean(name = "red")
    public Red  Red(){
        return new Red();
    }

    @Bean(name = "green")
    public Green green(){
        return new Green();
    }
}
