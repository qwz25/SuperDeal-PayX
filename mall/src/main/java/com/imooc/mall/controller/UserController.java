package com.imooc.mall.controller;

import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm) {
//        if(bindingResult.hasErrors()) {
//            log.error("注册提交的参数有误,{} {}",
//                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
//                    bindingResult.getFieldError().getDefaultMessage());
//            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
//        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
    }
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userForm, HttpSession session){
//        if(bindingResult.hasErrors()) {
//            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
//        }
        ResponseVo<User> userResponseVo = userService.login(userForm.getUsername(), userForm.getPassword());
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId:{}",session.getId());
        return userResponseVo;
    }
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/user sessionId:{}",session.getId());
        User user = (User) session.getAttribute(CURRENT_USER);
        return ResponseVo.success(user);
    }
    @PostMapping("/user/logout")
    public ResponseVo<User> logout(HttpSession session){
        log.info("/user/logout sessionId:{}",session.getId());
        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }
}
