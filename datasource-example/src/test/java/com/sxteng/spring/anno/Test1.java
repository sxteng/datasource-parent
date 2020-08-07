package com.sxteng.spring.anno;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @author shixtf
 * @description:
 * @date 2019/8/15  17:16
 */
@Component
public class Test1 {

    public static void main(String[] args) {
        LinkedHashMap<String ,String> hashMap = new LinkedHashMap<>();
        hashMap.get("eee");
    }
}
