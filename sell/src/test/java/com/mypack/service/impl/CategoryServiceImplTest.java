package com.mypack.service.impl;

import com.mypack.domain.ProductCategory;
import com.mypack.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void get() {
        ProductCategory productCategory = categoryService.get(10);
        System.out.println(productCategory);
    }

    @Test
    public void listAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategories);
        }
    }

    @Test
    public void getByCategoryType() {
        List<ProductCategory> byCategoryType = categoryService.findByCategoryType(Arrays.asList(1, 2, 3));
        for (ProductCategory productCategory : byCategoryType) {
            System.out.println(productCategory);
        }

    }


    @Test
    public void save() {
        ProductCategory p = new ProductCategory("nan",10);

        ProductCategory save = categoryService.save(p);
        System.out.println(save);
    }
}