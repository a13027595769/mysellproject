package com.mypack.controller;

import com.lly835.bestpay.model.PayResponse;
import com.mypack.dto.OrderDTO;
import com.mypack.enums.ResultEnum;
import com.mypack.exception.SellException;
import com.mypack.service.OrderService;
import com.mypack.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;
    @GetMapping("create")
    public ModelAndView create(@RequestParam("orderId")String orderId,
                               @RequestParam("returnUrl")String returnUrl,
                                Map<String,Object> Map){
        OrderDTO orderDTO = new OrderDTO();
        //1.查询订单
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        PayResponse payResponse = payService.create(orderDTO);
        Map.put("payResponse",payResponse);
        //发起支付
        return new ModelAndView("pay/create",Map);

    }
}
