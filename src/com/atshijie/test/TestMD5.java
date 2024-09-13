package com.atshijie.test;

import com.atshijie.util.MD5Util;
import org.junit.Test;

public class TestMD5 {
    @Test
    public void test() throws Exception{
        String encrypt = MD5Util.encrypt("1234");
        System.out.println(encrypt);
    }
}
