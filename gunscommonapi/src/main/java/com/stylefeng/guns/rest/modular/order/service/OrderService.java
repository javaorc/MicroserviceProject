package com.stylefeng.guns.rest.modular.order.service;

import com.stylefeng.guns.rest.modular.order.OrderInfo;
import com.stylefeng.guns.rest.modular.order.TicketInfo;

import java.util.List;

public interface OrderService {
    OrderInfo createOrder(TicketInfo ticketInfo, String username);

    List<OrderInfo> getOrderInfo(String username);

    Boolean isTrueSeats (Integer filedId,String seatId);

    Boolean isSoldSeats (Integer filedId,String seatId);
}
