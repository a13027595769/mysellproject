package com.mypack.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categroyType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOS;
}
