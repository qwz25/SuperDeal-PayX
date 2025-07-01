package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {
    private Integer productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
    private String productSubtitle;
    private String productMainImage;
    private Integer productStatus;
    private BigDecimal productTotalPrice;
    private Integer productStock;
    private Boolean productSelected;

    public CartProductVo(Integer productId, String productName, BigDecimal productPrice, Integer quantity, String productSubtitle, String productMainImage, Integer productStatus, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productSubtitle = productSubtitle;
        this.productMainImage = productMainImage;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
