package com.sxteng.spring.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author shixtf
 * @description:
 * @date 2019/8/15  17:16
 */
@Component
public class Test2 {

    public Test2() {
        System.out.println("===============");
        System.out.println("===============");
        System.out.println("===============");
    }

    @Bean
    public Test2 test2exapmle() {
        return new Test2();
    }

}
