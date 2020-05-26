package com.ng.demo.config;


import com.ng.demo.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


 /**
 * Created by Intellij IDEA.
 *用于将一些实体类放入Spring容器
 * @author  ng
 * Date:  2020/5/26
 */
@Configuration
public class BeanConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
