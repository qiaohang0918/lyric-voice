package com.test.custom;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Set;

/**
 * @Aurher: QiaoHang
 * @Description:
 * @Data: 2019/9/12 10:02
 * @Modified By:
 */
public class MyFilterType implements TypeFilter {
    /**
     *
     * @param metadataReader    当前读取到的元数据(.class文件)
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取元数据上的注解信息（@Aannocation）
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> types = annotationMetadata.getAnnotationTypes();
        System.out.println(types);
        //获取类的元数据
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("classMeta:--{}:"+classMetadata);
        //获取元素据资源信息(.class)
        String filename = metadataReader.getResource().getFilename();
        URI uri = metadataReader.getResource().getURI();
        URL url = metadataReader.getResource().getURL();
        File file = metadataReader.getResource().getFile();
        System.out.println("MyTypeFilter过滤器名字："+filename);
        System.out.println("MyTypeFilter过滤器url："+url);
        System.out.println("MyTypeFilter过滤器uri："+uri);
        System.out.println("MyTypeFilter过滤器file："+file);
        /**
         * 输出结果------>  由此可见uri和url没区别， file表示当前正在作用到的class文件元数据，
         * MyTypeFilter过滤器名字：MyReiponstory.class
         * MyTypeFilter过滤器url：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/dao/MyReiponstory.class
         * MyTypeFilter过滤器uri：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/dao/MyReiponstory.class
         * MyTypeFilter过滤器file：C:\Users\xltc-1\Desktop\lyricvoice\target\classes\com\test\dao\MyReiponstory.class
         * MyTypeFilter过滤器名字：MyController.class
         * MyTypeFilter过滤器url：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/controller/MyController.class
         * MyTypeFilter过滤器uri：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/controller/MyController.class
         * MyTypeFilter过滤器file：C:\Users\xltc-1\Desktop\lyricvoice\target\classes\com\test\controller\MyController.class
         * MyTypeFilter过滤器名字：MyService.class
         * MyTypeFilter过滤器url：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/service/MyService.class
         * MyTypeFilter过滤器uri：file:/C:/Users/xltc-1/Desktop/lyricvoice/target/classes/com/test/service/MyService.class
         * MyTypeFilter过滤器file：C:\Users\xltc-1\Desktop\lyricvoice\target\classes\com\test\service\MyService.class
         */
        System.out.println("**********************************************************************************");
        if(filename.contains("MyReiponstory")){
            //过滤文件名为MyReiponstory的类，不加载其实例
            return true;
        }
        return false;
    }
}
