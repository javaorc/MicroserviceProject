package com.stylefeng.guns.rest.modular.order;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo implements Serializable {

    private String orderId;

    private String filmName;

    private Date fieldTime;

    private String cinemaName;

    private String seatsName;

    private double orderPrice;

    private String orderTimestamp;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(Date fieldTime) {
        this.fieldTime = fieldTime;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(String orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public OrderInfo() {
    }

    public OrderInfo(String orderId, String filmName, Date fieldTime, String cinemaName, String seatsName, double orderPrice, String orderTimestamp) {
        this.orderId = orderId;
        this.filmName = filmName;
        this.fieldTime = fieldTime;
        this.cinemaName = cinemaName;
        this.seatsName = seatsName;
        this.orderPrice = orderPrice;
        this.orderTimestamp = orderTimestamp;
    }
}
