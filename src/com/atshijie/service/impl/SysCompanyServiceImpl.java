package com.atshijie.service.impl;

import com.atshijie.dao.SysCompanyDao;
import com.atshijie.dao.impl.SysCompanyDaoImpl;
import com.atshijie.pojo.SysCompany;
import com.atshijie.service.SysCompanyService;

import java.util.List;

public class SysCompanyServiceImpl implements SysCompanyService {
    private SysCompanyDao sysCompanyDao = new SysCompanyDaoImpl();

    @Override
    public List<SysCompany> findAll() {
        return sysCompanyDao.findAll();
    }
}
