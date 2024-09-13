package com.atshijie.test;

import com.atshijie.pojo.SysUser;
import com.atshijie.service.SysUserService;
import com.atshijie.service.impl.SysUserServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSysUserService {

    private static SysUserService sysUserService;

    @BeforeClass
    public static void initUser() throws Exception{
        sysUserService = new SysUserServiceImpl();
    }

    @Test
    public void testAdd() throws Exception{
        int i = sysUserService.addNewUser(new SysUser(null, "xiaoming", "123456", "shuaige"));
        System.out.println(i);
    }
}
