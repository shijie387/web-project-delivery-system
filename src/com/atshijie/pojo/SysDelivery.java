package com.atshijie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDelivery implements Serializable {
    private Integer id;
    private String deliveryName;
    private Integer userId;
    private Integer companyId;
    private String phone;
    private String address;
    private Date sendTime;
    private Integer state;

    private String companyName;
}
