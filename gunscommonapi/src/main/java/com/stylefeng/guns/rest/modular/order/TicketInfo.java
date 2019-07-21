package com.stylefeng.guns.rest.modular.order;

import java.io.Serializable;

public class TicketInfo implements Serializable {
    private Integer fieldId;
    private String soldSeats;
    private String seatsName;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }
}
