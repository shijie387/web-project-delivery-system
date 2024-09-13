package com.atshijie.service.impl;

import com.atshijie.dao.SysDeliveryDao;
import com.atshijie.dao.impl.SysDeliveryDaoImpl;
import com.atshijie.pojo.SysDelivery;
import com.atshijie.service.SysDeliveryService;

import java.util.List;

public class SysDeliveryServiceImpl implements SysDeliveryService {
    private SysDeliveryDao sysDeliveryDao= new SysDeliveryDaoImpl();

    @Override
    public List<SysDelivery> findByUserId(Integer userId) {
        return sysDeliveryDao.findByUserId(userId);
    }

    @Override
    public int save(SysDelivery delivery) {
        return sysDeliveryDao.add(delivery);
    }

    @Override
    public int removeById(int id) {
        return sysDeliveryDao.removeById(id);
    }

    @Override
    public SysDelivery findById(int id) {
        return sysDeliveryDao.findById(id);
    }

    @Override
    public int updateDelivery(SysDelivery delivery) {
        return sysDeliveryDao.update(delivery);
    }
}
