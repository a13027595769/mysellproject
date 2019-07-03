package com.mypack.repository;

import com.mypack.domain.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

   @Test
    public void testSave() throws Exception{

        ProductInfo p = new ProductInfo();
        p.setProductId("3");
        p.setCategoryType(13);
        p.setProductDescription("好喝啊");
        p.setProductName("粥");
        p.setProductStock(23);
        p.setProductPrice(new BigDecimal(100));
        p.setProductIcon("xxx.jpg");
        p.setProductStatus(2);
        ProductInfo save = repository.save(p);
        System.out.println(save);
    }
    @Test
    public void testFind() throws Exception{

        List<ProductInfo> list = repository.findByProductStatus(0);
        System.out.println(list);
    }



}