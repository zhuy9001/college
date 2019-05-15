package com.zhuy.edi.model;

import java.io.Serializable;

/**
 * @Classname OrderAddressInfo
 * @Description TODO
 * @Date 2019/5/14 10:35
 * @Created by  zhuy
 */
public class OrderAddressInfo  implements Serializable {
    private String ShipToAddressLine1;
    private String ShipToAddressLine2;
    private String ShipToAddressLine3;
    private String ShipToAddressLine4;
    private String ShipToZipCode;
    private String ShipToCity;
    private String ShipToCounty;
    private String ShipToState;
    private String ShipToCountry;
    private String ShipToPhone;

    public String getShipToAddressLine1() {
        return ShipToAddressLine1;
    }

    public void setShipToAddressLine1(String shipToAddressLine1) {
        ShipToAddressLine1 = shipToAddressLine1;
    }

    public String getShipToAddressLine2() {
        return ShipToAddressLine2;
    }

    public void setShipToAddressLine2(String shipToAddressLine2) {
        ShipToAddressLine2 = shipToAddressLine2;
    }

    public String getShipToAddressLine3() {
        return ShipToAddressLine3;
    }

    public void setShipToAddressLine3(String shipToAddressLine3) {
        ShipToAddressLine3 = shipToAddressLine3;
    }

    public String getShipToAddressLine4() {
        return ShipToAddressLine4;
    }

    public void setShipToAddressLine4(String shipToAddressLine4) {
        ShipToAddressLine4 = shipToAddressLine4;
    }

    public String getShipToZipCode() {
        return ShipToZipCode;
    }

    public void setShipToZipCode(String shipToZipCode) {
        ShipToZipCode = shipToZipCode;
    }

    public String getShipToCity() {
        return ShipToCity;
    }

    public void setShipToCity(String shipToCity) {
        ShipToCity = shipToCity;
    }

    public String getShipToCounty() {
        return ShipToCounty;
    }

    public void setShipToCounty(String shipToCounty) {
        ShipToCounty = shipToCounty;
    }

    public String getShipToState() {
        return ShipToState;
    }

    public void setShipToState(String shipToState) {
        ShipToState = shipToState;
    }

    public String getShipToCountry() {
        return ShipToCountry;
    }

    public void setShipToCountry(String shipToCountry) {
        ShipToCountry = shipToCountry;
    }

    public String getShipToPhone() {
        return ShipToPhone;
    }

    public void setShipToPhone(String shipToPhone) {
        ShipToPhone = shipToPhone;
    }
}
