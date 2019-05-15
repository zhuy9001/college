package com.zhuy.edi.model;

import java.io.Serializable;

/**
 * @Classname OrderDetail
 * @Description TODO
 * @Date 2019/5/14 10:31
 * @Created by  zhuy
 */
public class OrderDetail implements Serializable {
    private String orderItemNum;
    private String orderItemName;
    private String orderQty;

    public String getOrderItemNum() {
        return orderItemNum;
    }

    public void setOrderItemNum(String orderItemNum) {
        this.orderItemNum = orderItemNum;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }
}
