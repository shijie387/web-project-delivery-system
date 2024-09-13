package com.atshijie.dao;

import com.atshijie.pojo.SysDelivery;

import java.util.List;

public interface SysDeliveryDao {

    List<SysDelivery> findByUserId(Integer userId);

    int add(SysDelivery delivery);

    int removeById(int id);

    SysDelivery findById(int id);

    SysDelivery fineById(int id);

    int update(SysDelivery delivery);
}
