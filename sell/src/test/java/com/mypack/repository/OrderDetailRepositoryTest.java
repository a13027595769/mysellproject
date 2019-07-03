package com.mypack.repository;

import com.mypack.domain.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository detail;
    
    @Test
    public void testfind() throws Exception{
        List<OrderDetail> byOrderId = detail.findByOrderId("10");
        for (OrderDetail orderDetail : byOrderId) {
            System.out.println(orderDetail);
        }
    }
    @Test
    public void testSave() throws Exception{
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("10");
        orderDetail.setProductIcon("xxx.jpg");
        orderDetail.setProductId("1");
        orderDetail.setProductName("扁粉菜");
        orderDetail.setProductPrice(new BigDecimal(100));
        orderDetail.setProductQuantity(10);
        OrderDetail save = detail.save(orderDetail);
        System.out.println(save);

    }
    
}