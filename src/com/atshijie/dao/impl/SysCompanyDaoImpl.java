package com.atshijie.dao.impl;

import com.atshijie.dao.BaseDao;
import com.atshijie.dao.SysCompanyDao;
import com.atshijie.pojo.SysCompany;

import java.util.List;

public class SysCompanyDaoImpl extends BaseDao implements SysCompanyDao {
    @Override
    public List<SysCompany> findAll() {
        String sql = "select id, company_name companyName from sys_company";
        List<SysCompany> sysCompanyList = baseQuery(SysCompany.class, sql);
        return sysCompanyList!=null && sysCompanyList.size()>0 ? sysCompanyList : null;
    }
}
