package com.atshijie.test;

import com.atshijie.dao.SysDeliveryDao;
import com.atshijie.dao.impl.SysDeliveryDaoImpl;
import com.atshijie.pojo.SysDelivery;
import org.junit.Test;

import java.util.List;

public class TestSysDeliveryDao {
    @Test
    public void testFindById() throws Exception{
        SysDeliveryDaoImpl sysDeliveryDao = new SysDeliveryDaoImpl();

        List<SysDelivery> byUserId = sysDeliveryDao.findByUserId(1);
        byUserId.forEach(System.out::println);
    }
}
