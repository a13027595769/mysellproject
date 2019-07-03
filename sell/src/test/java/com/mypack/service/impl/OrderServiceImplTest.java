package com.mypack.service.impl;

import com.mypack.domain.OrderDetail;
import com.mypack.dto.OrderDTO;
import com.mypack.enums.OrderStatusEnum;
import com.mypack.enums.PayStatusEnum;
import com.mypack.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID="110110";

    private final String ORDER_ID="1557630027815117086";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAdress("伊斯坦布尔");
        orderDTO.setBuyerName("foo");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("123456789");

        //购物车

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("5");
        o1.setProductQuantity(1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("1");
        o2.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        for (int i=0;i<4;i++){

            OrderDTO result = orderService.create(orderDTO);
        }

       // log.info("[创建订单]result ->{}",result);
    }

    @Test
    public void findOne() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        System.out.println(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, request);
        List<OrderDTO> content = list.getContent();
        for (OrderDTO orderDTO : content) {
            System.out.println(orderDTO);
        }

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.cancel(orderDTO);
        //System.out.println(OrderStatusEnum.CANCEL.getCode());
        //System.out.println(cancel.getPayStatus());
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),cancel.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void findList2() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> list = orderService.findList(request);
        System.out.println(list.getTotalElements());
        List<OrderDTO> content = list.getContent();
        for (OrderDTO orderDTO : content) {
            System.out.println(orderDTO);
        }

    }
}