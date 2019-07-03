package com.mypack.repository;

import com.mypack.domain.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void testfindOne() throws Exception{
        ProductCategory category = repository.findOne(1);
        System.out.println(category);
    }
    @Test
    public void testSave() throws Exception{
        ProductCategory p = new ProductCategory();
        p.setCategoryName("女生最爱");
        p.setCategoryType(3);
        repository.save(p);
    }
    @Test
    public void testupdate() throws Exception{

        ProductCategory p = repository.findOne(1);

        p.setCategoryType(3);
        repository.save(p);
    }

    @Test
    public void findByCategoayTypeIn() throws Exception{

        List<Integer> integers = Arrays.asList(1, 2);
        List<ProductCategory> typeIn = repository.findByCategoryTypeIn(integers);

        for (ProductCategory productCategory : typeIn) {
            System.out.println(productCategory);
        }

    }
    @Test
    public void findByCategoayTypeIn1() throws Exception{
        List<ProductCategory> all = repository.findAll();

        for (ProductCategory productCategory : all) {

            System.out.println(productCategory);
        }

    }



}