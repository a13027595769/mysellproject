package com.mypack.controller;

import com.mypack.VO.ProductInfoVO;
import com.mypack.VO.ProductVO;
import com.mypack.VO.ResultVO;
import com.mypack.domain.ProductCategory;
import com.mypack.domain.ProductInfo;
import com.mypack.service.CategoryService;
import com.mypack.service.ProductService;
import com.mypack.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目(一次性查询)
   /*     List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //lambda表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryType(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategroyType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOS(productInfoVOList);
            productVOList.add(productVO);


        }

        //设置最终返回的vo对象

        return ResultVOUtil.success(productVOList);
      /*  ResultVO resultVO = new ResultVO();

        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");*/


      /*  //商品描述
        ProductVO productVO = new ProductVO();
        productVO.setCategoryName("1");
        productVO.setCategroyType(3);
        //商品的具体描述信息
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setProductDescription("hehe");
        productInfoVO.setProductIcon("123");
        productInfoVO.setProductId("0");
        productInfoVO.setProductName("aaa");
        productInfoVO.setProductPrice(new BigDecimal(100));
        //把商品的具体细节放到商品对象中去
        productVO.setProductInfoVOS(Arrays.asList(productInfoVO));
        //商品的具体信息放到最终返回对象中去
        resultVO.setData(Arrays.asList(productVO));*/
        //return resultVO;
    }
}
