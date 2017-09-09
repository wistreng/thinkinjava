package com.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Chapter2 {

    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put(1,"1");
        map.put(2,"2");
        String i = (String)map.get(1);
        System.out.println(i);
    }

}
