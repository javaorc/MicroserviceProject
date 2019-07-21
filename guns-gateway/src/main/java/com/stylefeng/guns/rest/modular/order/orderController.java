package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.stylefeng.guns.rest.modular.user.responseVO.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import sun.security.krb5.internal.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class orderController {
    @Autowired
    JwtProperties jwtPro;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Reference
    OrderService orderService;

    @RequestMapping(value = ("/buyTickets"),method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo getTickets(@RequestBody TicketInfo ticketInfo, HttpServletRequest request){

        String requestHeader = request.getHeader(jwtPro.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);}
        String name = jwtTokenUtil.getUsernameFromToken(authToken);
        Jedis jedis = new Jedis();
        String username = jedis.get(name);
        if(username!=null){
            Boolean trueSeats = orderService.isTrueSeats(ticketInfo.getFieldId(), ticketInfo.getSoldSeats());
            Boolean soldSeats = orderService.isSoldSeats(ticketInfo.getFieldId(), ticketInfo.getSoldSeats());
            if(trueSeats&&!soldSeats){
            OrderInfo order = orderService.createOrder(ticketInfo, username);
            return new ResponseVo(order,0,"");
            }
            return new ResponseVo(null,1,"该订单不存在");
        }
        return new ResponseVo(null,700,"expire");
    }

    @RequestMapping(value = ("/getOrderInfo"),method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo getOrderInfo(String nowPage,String pageSize ,HttpServletRequest request){

            String requestHeader = request.getHeader(jwtPro.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);}
        String name = jwtTokenUtil.getUsernameFromToken(authToken);
        Jedis jedis = new Jedis();
        String username = jedis.get(name);
        if(username!=null){
            List<OrderInfo> orderInfos = orderService.getOrderInfo(username);
            if(orderInfos.size()!=0) {
                return new ResponseVo(orderInfos, 0, "");
            }
            return new ResponseVo(null,1,"订单列表为空哦");
        }
        return new ResponseVo(null,700,"expire");
    }



}
