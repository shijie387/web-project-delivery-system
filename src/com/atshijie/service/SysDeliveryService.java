package com.atshijie.service;

import com.atshijie.pojo.SysDelivery;

import java.util.List;

public interface SysDeliveryService {

    List<SysDelivery> findByUserId(Integer userId);

    int save(SysDelivery delivery);

    int removeById(int id);

    SysDelivery findById(int id);

    int updateDelivery(SysDelivery delivery);
}
