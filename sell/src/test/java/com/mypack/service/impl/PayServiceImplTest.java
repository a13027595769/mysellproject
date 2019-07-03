package com.mypack.service.impl;

import com.mypack.dto.OrderDTO;
import com.mypack.service.OrderService;
import com.mypack.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1557630027815117086");

        payService.create(orderDTO);
    }
}