package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sortOrder;
    private List<CategoryVo> subCategories;
}
