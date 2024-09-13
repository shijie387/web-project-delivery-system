package com.atshijie.dao.impl;

import com.atshijie.dao.BaseDao;
import com.atshijie.dao.SysDeliveryDao;
import com.atshijie.pojo.SysDelivery;

import java.util.List;

public class SysDeliveryDaoImpl extends BaseDao implements SysDeliveryDao {
    @Override
    public List<SysDelivery> findByUserId(Integer userId) {
        String sql = "select d.id id, delivery_name deliveryName , user_id userId , company_id companyId , phone , address , state ,send_time sendTime, company_name companyName \n" +
                "from sys_delivery d left join sys_company c on d.company_id=c.id\n" +
                "where user_id = ?";
        return baseQuery(SysDelivery.class, sql, userId);
    }

    @Override
    public int add(SysDelivery delivery) {
        String sql = "insert into sys_delivery values(DEFAULT,?,?,?,?,?,?,?)";
        return baseUpdate(
                sql,
                delivery.getDeliveryName(),
                delivery.getUserId(),
                delivery.getCompanyId(),
                delivery.getPhone(),
                delivery.getAddress(),
                delivery.getSendTime(),
                delivery.getState()
        );
    }

    @Override
    public int removeById(int id) {
        return baseUpdate("delete from sys_delivery where id=?", id);
    }


    @Override
    public SysDelivery findById(int id) {
        String sql = """
                select
                    id,
                    delivery_name deliveryName,
                    user_id  userId,
                    company_id companyId,
                    phone,
                    address,
                    send_time sendTime,
                    state
                from 
                    sys_delivery 
                   
                where 
                    id = ?
                """;
        List<SysDelivery> deliveries = baseQuery(SysDelivery.class, sql, id);
        return deliveries != null && deliveries.size()>0?deliveries.get(0):null;
    }


    @Override
    public SysDelivery fineById(int id) {
        String sql = """
                select
                    id,
                    delivery_name deliveryName,
                    user_id  userId,
                    company_id companyId,
                    phone,
                    address,
                    send_time sendTime,
                    state
                from 
                    sys_delivery 
                   
                where 
                    id = ?
                """;
        List<SysDelivery> deliveries = baseQuery(SysDelivery.class, sql, id);
        return deliveries != null && deliveries.size()>0?deliveries.get(0):null;
    }

    @Override
    public int update(SysDelivery delivery) {
        String sql = """
                update 
                    sys_delivery
                set   
                     delivery_name = ?,
                     user_id =? ,
                     company_id =?,
                     phone = ?,
                     address =?,
                     send_time =?,
                     state = ?
                where 
                    id= ?  
                """;
        return baseUpdate(
                sql,
                delivery.getDeliveryName(),
                delivery.getUserId(),
                delivery.getCompanyId(),
                delivery.getPhone(),
                delivery.getAddress(),
                delivery.getSendTime(),
                delivery.getState(),
                delivery.getId()
        );
    }
}
