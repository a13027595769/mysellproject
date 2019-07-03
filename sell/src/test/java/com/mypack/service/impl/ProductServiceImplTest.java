package com.mypack.service.impl;

import com.mypack.domain.ProductInfo;
import com.mypack.enums.ProductStatusEnum;
import com.mypack.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductService service;
    @Test
    public void findOne() {
        ProductInfo one = service.findOne("1");
        System.out.println(one);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = service.findUpAll();
        for (ProductInfo productInfo : upAll) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void findAll() {

        PageRequest request = new PageRequest(0,1);
        Page<ProductInfo> all = service.findAll(request);
        List<ProductInfo> content = all.getContent();
        System.out.println("总个数"+all.getTotalElements());
        for (ProductInfo productInfo : content) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void save() {

        ProductInfo p = new ProductInfo();
        p.setProductId("5");
        p.setCategoryType(13);
        p.setProductDescription("好吃啊");
        p.setProductName("扁粉菜");
        p.setProductStock(100);
        p.setProductPrice(new BigDecimal(100));
        p.setProductIcon("yyy.jpg");
        p.setProductStatus(1);
        ProductInfo save = service.save(p);
        System.out.println(save);
    }
    @Test
    public void onSale() {
        ProductInfo result = service.onSale("5");
        Assert.assertEquals(ProductStatusEnum.UP,result.getProductStatusEnum());
        System.out.println(result.getProductStatus());
    }
    @Test
    public void offSale() {
        ProductInfo result = service.onSale("5");
        Assert.assertEquals(ProductStatusEnum.UP,result.getProductStatusEnum());
        System.out.println(result.getProductStatus());
    }
}