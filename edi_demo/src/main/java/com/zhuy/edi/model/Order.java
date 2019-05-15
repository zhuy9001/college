package com.zhuy.edi.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2019/5/14 10:25
 * @Created by  zhuy
 */
public class Order implements Serializable {

    private  String orderNumber;
    private String OrderWeightUOM;
    private String OrderVolumeUOM;
    private String OrderOrigTotalWeight;
    private String OrderOrigTotalVolume;
    private String ShipCarrier;
    private String ShipJDECarrierNum;
    private String quantity;
    private List<OrderDetail> detail;
    private OrderAddressInfo addressInfo;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderWeightUOM() {
        return OrderWeightUOM;
    }

    public void setOrderWeightUOM(String orderWeightUOM) {
        OrderWeightUOM = orderWeightUOM;
    }

    public String getOrderVolumeUOM() {
        return OrderVolumeUOM;
    }

    public void setOrderVolumeUOM(String orderVolumeUOM) {
        OrderVolumeUOM = orderVolumeUOM;
    }

    public String getOrderOrigTotalWeight() {
        return OrderOrigTotalWeight;
    }

    public void setOrderOrigTotalWeight(String orderOrigTotalWeight) {
        OrderOrigTotalWeight = orderOrigTotalWeight;
    }

    public String getOrderOrigTotalVolume() {
        return OrderOrigTotalVolume;
    }

    public void setOrderOrigTotalVolume(String orderOrigTotalVolume) {
        OrderOrigTotalVolume = orderOrigTotalVolume;
    }

    public String getShipCarrier() {
        return ShipCarrier;
    }

    public void setShipCarrier(String shipCarrier) {
        ShipCarrier = shipCarrier;
    }

    public String getShipJDECarrierNum() {
        return ShipJDECarrierNum;
    }

    public void setShipJDECarrierNum(String shipJDECarrierNum) {
        ShipJDECarrierNum = shipJDECarrierNum;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public List<OrderDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<OrderDetail> detail) {
        this.detail = detail;
    }

    public OrderAddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(OrderAddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }
}
