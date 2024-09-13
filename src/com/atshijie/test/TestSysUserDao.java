package com.atshijie.test;

import com.atshijie.dao.BaseDao;
import com.atshijie.dao.SysUserDao;
import com.atshijie.dao.impl.SysUserDaoImpl;
import com.atshijie.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSysUserDao {
    private static SysUserDao sysUserDao;

    @BeforeClass
    public static void initBaseDao() throws Exception{
        sysUserDao = new SysUserDaoImpl();
    }

    @Test
    public void testFindByName() throws Exception{
        SysUser user = sysUserDao.findByUsername("root456");
        System.out.println(user);
    }
}
