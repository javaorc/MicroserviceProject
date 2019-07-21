package com.stylefeng.guns.rest.modular.order.service.impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.modular.order.OrderInfo;
import com.stylefeng.guns.rest.modular.order.TicketInfo;
import com.stylefeng.guns.rest.modular.order.controller.MtimeHallDictTController;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.stylefeng.guns.rest.modular.user.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.UserInfo;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import org.apache.logging.log4j.util.Chars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service(interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    MoocOrderTMapper moocOrderTMapper;
    @Autowired(required = false)
    MtimeFieldTMapper mtimeFieldTMapper;
    @Reference
    IMtimeUserTService iMtimeUserTService;
    @Autowired(required = false)
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Autowired(required = false)
    MtimeHallDictTMapper mtimeHallDictTMapper;

    @Override
    public OrderInfo createOrder(TicketInfo ticketInfo,String username) {
        MtimeFieldT mtimeFieldT = mtimeFieldTMapper.selectById(ticketInfo.getFieldId());
        MtimeUserT mtimeUserT = iMtimeUserTService.getMtimeUserT(username);
        //OrderInfo orderInfo = new OrderInfo();
        //orderInfo.setOrderTimestamp(mtimeUserT.getUserPhone());
        //orderInfo.set
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(mtimeFieldT.getCinemaId());
        //orderInfo.setCinemaName(mtimeCinemaT.getCinemaName());
        String seats = ticketInfo.getSoldSeats();
        String[] seatsIds = seats.split(",");
        Double price= 1.0*mtimeFieldT.getPrice()*seatsIds.length;
        MoocOrderT moocOrderT = new MoocOrderT(UUID.randomUUID().toString(), mtimeFieldT.getCinemaId(),
                ticketInfo.getFieldId(), mtimeFieldT.getFilmId(), ticketInfo.getSoldSeats(),
                ticketInfo.getSeatsName(), 1.0 * mtimeFieldT.getPrice(), price,
                new Date(), mtimeUserT.getUuid(), 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer insert = moocOrderTMapper.insert(moocOrderT);
        String substring=null;
        Date parse=null;
        try {
            substring =simpleDateFormat.format(moocOrderT.getOrderTime()).toString().substring(0, 10);
            String s = new StringBuffer(substring).append(" ").append(mtimeFieldT.getBeginTime()).append(":00").toString();
            parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OrderInfo orderInfo = new OrderInfo(moocOrderT.getUuid(), mtimeFieldT.getHallName(), parse,
                mtimeCinemaT.getCinemaName(), moocOrderT.getSeatsName(), price,
                mtimeUserT.getUserPhone());
        return orderInfo;
    }

    @Override
    public List<OrderInfo> getOrderInfo(String username) {
        MtimeUserT mtimeUserT = iMtimeUserTService.getMtimeUserT(username);
        List<MoocOrderT> orders = moocOrderTMapper.getOrdersByUid(mtimeUserT.getUuid());
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        for(MoocOrderT order:orders){
            MtimeFieldT mtimeFieldT = mtimeFieldTMapper.selectById(order.getFieldId());
            MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(mtimeFieldT.getCinemaId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String seats = order.getSeatsIds();
            String[] seatsIds = seats.split(",");
            Double price= 1.0*mtimeFieldT.getPrice()*seatsIds.length;

            String substring=null;
            Date parse=null;
            try {
                substring =simpleDateFormat.format(order.getOrderTime()).toString().substring(0, 10);
                String s = new StringBuffer(substring).append(" ").append(mtimeFieldT.getBeginTime()).append(":00").toString();
                parse = simpleDateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            OrderInfo orderInfo = new OrderInfo(order.getUuid(), mtimeFieldT.getHallName(), parse,
                    mtimeCinemaT.getCinemaName(), order.getSeatsName(), price,
                    mtimeUserT.getUserPhone());
            orderInfos.add(orderInfo);
        }

        return orderInfos;
    }

    @Override
    public Boolean isTrueSeats(Integer filedId, String seatId) {
        MtimeFieldT mtimeFieldT = mtimeFieldTMapper.selectById(filedId);
        //MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(mtimeFieldT.getCinemaId());
        //mtimeCinemaT.get
        MtimeHallDictT mtimeHallDictT = mtimeHallDictTMapper.selectById(mtimeFieldT.getHallId());
        String seatAddress = mtimeHallDictT.getSeatAddress();
        String myPath="F:\\film-front\\film-front\\static\\json"+seatAddress;

        FileInputStream inputstream = null;
        int cnt=0;
        String seatIds=null;
            try {
                inputstream = new FileInputStream(myPath);
                String line; // 用来保存每行读取的内容
                BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream));
                line = bufferreader.readLine(); // 读取第一行

                while (line != null&&cnt<4) { // 如果 line 为空说明读完了
		            cnt++;
                    line = bufferreader.readLine(); // 读取下一行
                    if(cnt==2){
                        seatIds=line;
                    }
                }
//		 将读到 buffer 中的内容写出来
                inputstream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            seatIds.replaceAll(" ","");
        String[] split = seatIds.split(":");
        String ids=split[1];
        String s = ids.replaceAll("\"", "");
        String[] split1 = seatId.split(",");
        int count=split1.length;
        for(String s1:split1){
            if(s.contains(s1)){
                count--;
            }
        }

        return count==0;



    }

    @Override
    public Boolean isSoldSeats(Integer filedId, String seatId) {
        List<MoocOrderT> orders = moocOrderTMapper.getOrdersByFieldId(filedId);
        boolean flag=false;
        for(MoocOrderT order:orders){
            String seatsIds = order.getSeatsIds();
            if(myContains(seatsIds,seatId)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    private boolean myContains(String resource,String target){
        char[] chars1 = resource.replace(",","").toCharArray();
        char[] chars2 = target.replace(",","").toCharArray();
        int count=1;
        for(char c1:chars1){
            for(char c2:chars2 ){
                if(c1==c2){
                    count--;
                    break;
                }
            }
        }
        return count<1;
    }

}
