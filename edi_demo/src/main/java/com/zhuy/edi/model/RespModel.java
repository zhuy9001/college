package com.zhuy.edi.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname RespModel
 * @Description TODO
 * @Date 2019/5/14 10:23
 * @Created by  zhuy
 */
public class RespModel implements Serializable {

    private  String batchId;
    private List<Order> orders;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
