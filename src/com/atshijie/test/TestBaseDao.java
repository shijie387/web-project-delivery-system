package com.atshijie.test;

import com.atshijie.dao.BaseDao;
import com.atshijie.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestBaseDao {

    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() throws Exception{
        baseDao = new BaseDao();
    }

    @Test
    public void testQueryObject() throws Exception{
        String sql = "select count(1) from sys_user";
        Long i = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(i);
    }

    @Test
    public void testQueryAll() throws Exception{
        String sql = "select id,username,password,nickname from sys_user";
        List<SysUser> objects = baseDao.baseQuery(SysUser.class, sql);
        objects.forEach(System.out::println);
    }

    @Test
    public void testUpdate() throws Exception{
        String sql = "update sys_user set username=? where id=?";
        int i = baseDao.baseUpdate(sql, "root456", 1);
        System.out.println(i);
    }
}
