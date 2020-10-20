package com.li.car.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.li.car.entity.User;
import com.li.car.exception.BlackUserException;
import com.li.car.services.impl.UserServiceImpl;
import com.li.car.util.Utils;
import com.li.car.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Description: 登录
 * @Author: li
 * @Create: 2020-03-21 11:35
 */
@Slf4j
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserServiceImpl userService;

    private String className = "LoginController";

    /**
     * @Description: 生成验证码
     * @Param: [response , request]
     * @return: void
     */
    @GetMapping(value = "/getCode")
    public void getYzm(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpg");

            //生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

            Utils.printMsg("PublicController->verifyCode", verifyCode);
            //存入会话session
            HttpSession session = request.getSession(true);
            session.setAttribute("_code", verifyCode.toLowerCase());

            //生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 跳转到注册页面
     * @Param: []
     * @return: java.lang.String
     */
    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    /**
     * @Description: 将有效用户添加到数据库中
     * @Param: []
     * @return: java.lang.String
     */
@PostMapping("/register")
@ResponseBody
public Object register(User user) {
    //添加注册时间
    user.setCreateDate(new Date());
    //对密码进行加密
    user.setPwd(Utils.md5Code(user.getPwd()));

    Utils.printMsg(className, user);

    //将用户保存到数据库中
    boolean save = userService.save(user);

    if (save) {
        //保存成功
        return 1;
    } else {
        //保存失败
        return 0;
    }
}

    /**
     * @Description: 注册时 检查邮箱是否可用
     * @Param: [email]
     * @return: java.lang.Object
     */
    @PostMapping("/checkEmail")
    @ResponseBody
    public Object checkEmail(String email) {
        //查询邮箱是否可用
        int count = userService.count(Wrappers.<User>lambdaQuery().eq(User::getEmail, email));

        if (count != 0) {
            //邮箱已存在，不可用
            return 1;
        } else {
            //邮箱可用
            return 0;
        }
    }

    /***
     * @Description: 用户未认证时 跳转到 登录页面
     *              用户完成认证 跳转到 用户主页
     * @Param: []
     * @return: java.lang.String
     */
    @GetMapping("/")
    public String toIndex() {
        return "index";
    }

    /**
     * @Description: 登录
     * @Param: [email 用户名, pwd 密码]
     * @return: java.lang.String
     */
    @PostMapping("/login")
    public String login(String email, String pwd, Model model, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated() || subject.isRemembered()) {
            return "redirect:/user";
        }

        String codeMsg = (String) request.getAttribute("shiroLoginFailure");

        if ("code.error".equals(codeMsg)) {
            model.addAttribute("message", "验证码错误");
            return "/index";
        }

        //默认记住我
        UsernamePasswordToken token = new UsernamePasswordToken(email, pwd, true);

        //3 执行登录
        try {
            subject.login(token);
            //登录成功

            Object principal = subject.getPrincipal();

            Utils.printMsg(className + "->login", principal);

            return "redirect:/user";
        } catch (UnknownAccountException e) {
            //UnknownAccountException异常
            //表示登录失败，用户名不存在
            model.addAttribute("message", "用户名不存在");
            Utils.printMsg(className, "用户名不存在");

            return "/index";
        } catch (BlackUserException e) {
            //表示用户被拉黑
            model.addAttribute("message", "用户被拉黑");
            return "/index";
        } catch (IncorrectCredentialsException e) {
            //表示登录失败，密码错误
            model.addAttribute("message", "密码错误");
            Utils.printMsg(className, "密码错误");
            return "/index";
        }
    }
}
