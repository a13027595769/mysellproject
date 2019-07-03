package com.mypack.service;

import com.mypack.domain.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface CategoryService {
    ProductCategory get(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryType(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);
}
