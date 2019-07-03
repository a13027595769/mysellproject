package com.mypack.repository;

import com.mypack.domain.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    private final String OPENID = "1234567";
    @Test
    public void testfindByBuyerId() throws Exception{
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(byBuyerOpenid.getContent());
    }
    @Test
    public void testSave() throws Exception{
        OrderMaster master = new OrderMaster();
        master.setBuyerAdress("北京");
        master.setBuyerName("阿彪");
        master.setBuyerOpenid("1234567");
        master.setBuyerPhone("13027595769");
        master.setCreateTime(new Date());
        master.setOrderAmount(new BigDecimal(10.3));
        master.setOrderStatus(0);
        master.setPayStatus(0);
        master.setUpdateTime(new Date());
        master.setOrderId("10");

        OrderMaster save = repository.save(master);
        System.out.println(save);
    }
}