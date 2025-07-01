package com.imooc.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
@Slf4j
public class ICartServiceTest extends MallApplicationTests {
    @Autowired
    private ICartService cartService;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Integer productId = 26;
    private final Integer uid = 1;
    @Before
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelected(true);
        ResponseVo<CartVo> add = cartService.add(uid, form); // 写入到redis时的命名格式
        log.info("Result after add={}", gson.toJson(add));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), add.getStatus());
    }
    @Test
    public void list() {
        ResponseVo<CartVo> list = cartService.list(uid);
        log.info("list={}", gson.toJson(list));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), list.getStatus());
    }
    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(10);
        form.setSelected(false);
        ResponseVo<CartVo> update = cartService.update(uid, productId, form);
        log.info("Result after update={}", gson.toJson(update));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), update.getStatus());
    }
    @After
    public void delete() {
        ResponseVo<CartVo> delete = cartService.delete(uid, productId);
        log.info("Result after delete={}", gson.toJson(delete));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), delete.getStatus());
    }
    @Test
    public void selectAll(){
        ResponseVo<CartVo> selectALl = cartService.selectAll(uid);
        log.info("Result after selectAll={}", gson.toJson(selectALl));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), selectALl.getStatus());
    }
    @Test
    public void unselectAll() {
        ResponseVo<CartVo> unselectAll = cartService.unSelectAll(uid);
        log.info("Result after unselectAll={}", gson.toJson(unselectAll));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), unselectAll.getStatus());
    }
    @Test
    public void sum(){
        ResponseVo<Integer> sum = cartService.sum(uid);
        log.info("Result after sum={}", gson.toJson(sum));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), sum.getStatus());
    }
}