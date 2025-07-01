package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class UserRegisterForm {
    /*
    NotBlank 用于判断String 有无空格
    NotEmpty 用于集合
    NotNull 用于判断数值是否为null
     */
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
