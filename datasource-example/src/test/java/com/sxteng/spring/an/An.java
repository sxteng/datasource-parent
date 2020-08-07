package com.sxteng.spring.an;

import com.sxteng.spring.anno.Test1;
import com.sxteng.spring.anno.Test2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shixtf
 * @description:
 * @date 2019/8/15  17:05
 */


public class An {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanTest.class);
        Test2 test1 = (Test2)ctx.getBean("test2exapmle");
        Test2 test2 = (Test2)ctx.getBean("test2");
        System.out.println(test1);
        System.out.println(test2);

    }
}
