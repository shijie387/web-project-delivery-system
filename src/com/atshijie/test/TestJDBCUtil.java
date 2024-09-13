package com.atshijie.test;

import com.atshijie.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class TestJDBCUtil {
    @Test
    public void test1() throws Exception{
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
    }
}
