package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.SimpleObject;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.converter.BaseTransferEntity;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.util.Md5Util;
import com.stylefeng.guns.rest.modular.user.responseVO.ResponseVo;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.stylefeng.guns.rest.modular.user.service.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    IMtimeUserTService iMtimeUserTService;
    @Reference
    RegisterService registerService;
    @Autowired
    JwtProperties jwtPro;


    //@RequestMapping("/check")
    @RequestMapping(value =("/check"),method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo check( String username){
        boolean b = iMtimeUserTService.queryUserByUsername(username);
        if(!b){
            return new ResponseVo(null,0,"验证成功");
        }
        return new ResponseVo(null,1,"用户已存在");
    }
    //@RequestMapping("/register")
    @RequestMapping(value =("/register"),method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo register( RegisterInfo registerInfo ){
//        registerInfo.setUsername(MD5Util.encrypt(registerInfo.getUsername()));
        boolean b = iMtimeUserTService.queryUserByUsername(registerInfo.getUsername());
        if(b){
            return new ResponseVo(null,1,"用户已存在");
        }else {
            registerInfo.setPassword(MD5Util.encrypt(registerInfo.getPassword()));
            int i = registerService.insertUser(registerInfo);
            if (i > 0) {
                return new ResponseVo(null, 0, "注册成功");
            }
            return new ResponseVo(null, 999, "系统出现异常，请联系管理员");
        }
    }

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    //@RequestMapping("/getUserInfo")
    @RequestMapping(value =("/getUserInfo"),method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo getInfo(HttpServletRequest request){

        String requestHeader = request.getHeader(jwtPro.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);}
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if(username!=null){
        UserInfo userInfo = iMtimeUserTService.getUserInfoByUsername(username);
//            Jedis jedis = new Jedis();
//            jedis.set(username,username);
            return new ResponseVo(userInfo,0,"成功");
        }
        return new ResponseVo(null,1,"查询失败，用户尚未登陆");
    }

    //@RequestMapping("/logout")
    @RequestMapping(value =("/logout"),method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo logout(HttpServletRequest request){

        String requestHeader = request.getHeader(jwtPro.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);}
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if(username!=null){
           // UserInfo userInfo = iMtimeUserTService.getUserInfoByUsername(username);
            Jedis jedis = new Jedis();
            jedis.del(username);
            return new ResponseVo(null,0,"成功退出");
        }
        return new ResponseVo(null,1,"退出失败，用户尚未登陆");
    }

    //@RequestMapping("/updateUserInfo")
    @RequestMapping(value =("/updateUserInfo"),method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo updateInfo( UpdateInfo updateInfo, HttpServletRequest request){

        String requestHeader = request.getHeader(jwtPro.getHeader());
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);}
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if(username!=null){
            UpdateInfoShowBack updateInfoShowBack = iMtimeUserTService.updateAndGetInfoShowBack(updateInfo, username);
            return new ResponseVo(updateInfoShowBack,0,null);
        }
        return new ResponseVo(null,1,"用户信息修改失败");
    }

    }

