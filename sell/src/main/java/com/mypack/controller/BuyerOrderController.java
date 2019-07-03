package com.mypack.controller;

import com.mypack.VO.ResultVO;
import com.mypack.converter.OrderForm2OrderDTOConverter;
import com.mypack.dto.OrderDTO;
import com.mypack.enums.ResultEnum;
import com.mypack.exception.SellException;
import com.mypack.form.OrderForm;
import com.mypack.service.BuyerService;
import com.mypack.service.OrderService;
import com.mypack.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController implements Serializable {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

//订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
            if(StringUtils.isEmpty(openid)){
                log.error("【查询订单列表】openid为空");
                throw new SellException(ResultEnum.PARAM_ERROR);
            }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> list = orderService.findList(openid, request);
        return ResultVOUtil.success(list.getContent());


    }

    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId")String orderId){
        //TODO 不安全的做法 改进(已改进)

        //OrderDTO orderDTO = orderService.findOne(orderId);
        //return ResultVOUtil.success(orderDTO);
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId")String orderId){
        //TODO 不安全的做法 改进（已改进）
        //OrderDTO orderDTO = orderService.findOne(orderId);
        //orderService.cancel(orderDTO);
        //return ResultVOUtil.success();
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();

    }
}
