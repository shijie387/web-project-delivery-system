package com.atshijie.test;

import com.atshijie.dao.SysCompanyDao;
import com.atshijie.dao.impl.SysCompanyDaoImpl;
import com.atshijie.dao.impl.SysDeliveryDaoImpl;
import com.atshijie.pojo.SysCompany;
import com.atshijie.pojo.SysDelivery;
import org.junit.Test;

import java.util.List;

public class TestSysCompanyDao {
    @Test
    public void testFindAll() throws Exception{
        SysCompanyDaoImpl sysCompany = new SysCompanyDaoImpl();

        List<SysCompany> sysCompanyList = sysCompany.findAll();
        sysCompanyList.forEach(System.out::println);
    }


}
