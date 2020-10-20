package com.li.car.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.car.dto.PageDto;
import com.li.car.entity.CarPort;
import com.li.car.entity.Corder;
import com.li.car.entity.User;
import com.li.car.services.impl.CarPortServiceImpl;
import com.li.car.services.impl.CorderServiceImpl;
import com.li.car.services.impl.UserServiceImpl;
import com.li.car.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 16:37
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private String prefix = "admin/";

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CarPortServiceImpl carPortService;

    @Autowired
    private CorderServiceImpl corderService;


    @GetMapping
    public String toAdmin() {
        return prefix + "admin";
    }

    /**
     * @Description: 管理员欢迎页
     * @Param: []
     * @return: java.lang.String
     */
    @GetMapping("/welcome")
    public String welcome() {
        return prefix + "welcome";
    }

    @GetMapping("/userlist")
    public String toUserList() {
        return prefix + "member-listn";
    }


    /**
     * @Description: ajax 查询所有用户
     * @Param: []
     * @return: java.util.List<com.li.car.entity.User> 所有用户
     */
    @GetMapping("/user")
    @ResponseBody
    public PageDto<User> userList(String page, String limit, String condition) {

        Utils.printMsg("AdminController->userList:condition", condition);

        //根据条件 查找用户
        //select * from user where username = condition or eamil = condition


        boolean flag = !StringUtils.isEmpty(condition);

        Page<User> userPage = userService.page(new Page<>(Long.parseLong(page), Long.parseLong(limit)),
                Wrappers.<User>lambdaQuery().like(flag, User::getUserName, condition).or().like(flag, User::getEmail, condition));


        PageDto<User> dto = new PageDto<>();
        dto.setCode(0L);
        dto.setCount(userPage.getTotal());
        dto.setData(userPage.getRecords());


        Utils.printMsg("AdminController->userList", dto);
        return dto;
    }

    /**
     * @Description: 根据uid获取用户信息
     * @Param: [uid 用户id, model]
     * @return: java.lang.String
     */
    @GetMapping("/user/{uid}")
    public String getUserByUid(@PathVariable("uid") String uid, Model model) {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUid, uid));
        model.addAttribute("user", one);
        return prefix + "member-edit";
    }

    /**
     * @Description: 更改用户信息
     * @Param: [user 更新的用户信息]
     * @return: java.lang.Object
     */
    @PutMapping("/user")
    @ResponseBody
    public Object updUser(User user) {
        return userService.updateById(user);
    }

    /**
     * @Description: 批量拉黑用户
     * @Param: [uid, status]
     * @return: java.lang.Object
     */
    @PutMapping("/users")
    @ResponseBody
    public Object updUserStatus(String uid, String status) {

        Utils.printMsg("AdminController->updUserStatus:uid", uid);
        //将用户的json uid数组 转换成功String数组
        List<String> ids = JSON.parseArray(uid, String.class);
        Utils.printMsg("AdminController->updUserStatus:ids", ids);

        return userService.lambdaUpdate().in(User::getUid, ids).set(User::getStatus, status).update();
    }

    /**
     * @Description: 根据uid 删除用户
     * @Param: [uid 需要删除uid]
     * @return: java.lang.Object
     */
    @DeleteMapping("/user")
    @ResponseBody
    public Object delUser(String uid) {

        Utils.printMsg("AdminController->delUser:uid", uid);
        //将用户的json uid数组 转换成功String数组
        List<String> ids = JSON.parseArray(uid, String.class);
        Utils.printMsg("AdminController->updUserStatus:ids", ids);

        return userService.removeByIds(ids);
    }


    @GetMapping("carlist")
    public String toCarList() {
        return prefix + "car-list";
    }

    @GetMapping("caradd")
    public String toCarAdd() {
        return prefix + "car-add";
    }

    @GetMapping("orderlist")
    public String toOrder() {
        return prefix + "order-list";
    }


    /**
     * @Description: ajax 查询所有车辆
     * @Param: [page 当前页, limit 页面大小, cname 车名, crent 租金, status 车辆状态]
     * @return: com.li.car.dto.PageDto<com.li.car.entity.CarPort>
     */
    @GetMapping("/car")
    @ResponseBody
    public PageDto<CarPort> carList(String page, String limit, String cname, String crent, String status) {

        Utils.printMsg("AdminController->userList:cname", cname);
        Utils.printMsg("AdminController->userList:crent", crent);
        Utils.printMsg("AdminController->userList:status", status);

        //根据条件 查找车辆
        Page<CarPort> carPage = carPortService.page(new Page<CarPort>(Long.parseLong(page), Long.parseLong(limit)),
                Wrappers.<CarPort>lambdaQuery().like(!StringUtils.isEmpty(cname), CarPort::getCname, cname)
                        .like(!StringUtils.isEmpty(crent), CarPort::getCrent, crent)
                        .eq(!StringUtils.isEmpty(status), CarPort::getStatus, status));

        PageDto<CarPort> dto = new PageDto<>();
        dto.setCode(0L);
        dto.setCount(carPage.getTotal());
        dto.setData(carPage.getRecords());

        Utils.printMsg("AdminController->carList", dto);
        return dto;
    }


    /**
     * @Description: 更改车辆信息
     * @Param: [carPort 车辆信息]
     * @return: java.lang.Object
     */
    @PutMapping("/car")
    @ResponseBody
    public Object changeCarStatus(CarPort carPort) {
        return carPortService.updateById(carPort);
    }


    /**
     * @Description: 批量更新车辆状态
     * @Param: [cid json的id组, status]
     * @return: java.lang.Object
     */
    @PutMapping("/cars")
    @ResponseBody
    public Object changAllCarStatus(String cid, String status) {
        List<String> ids = JSON.parseArray(cid, String.class);
        return carPortService.lambdaUpdate().in(CarPort::getCid, ids).set(CarPort::getStatus, status).update();
    }

    /**
     * @Description: 上传图片
     * @Param: [file, request, response]
     * @return: java.lang.Object
     */
    @PostMapping("/img")
    @ResponseBody
    public Object headImg(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String path = "D:\\dev\\java\\car\\src\\main\\resources\\static\\images";

        //生成唯一标志 uuid
        String s = UUID.randomUUID().toString();
        //输出 f6634f9f-2750-45f8-a583-d44b391795ff
        //替换uuid中的 -
        //输出 f6634f9f275045f8a583d44b391795ff
        s.replaceAll("-", "");

        //获取文件名称
        String filename = s + file.getOriginalFilename();

        //上传文件
        file.transferTo(new File(path, filename));

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("src", "images/" + filename);
        return map;
    }

    /**
     * @Description: 添加新车辆
     * @Param: [carPort, model]
     * @return: java.lang.String
     */
    @PostMapping("/car")
    public String addCar(CarPort carPort, Model model) {
        boolean save = carPortService.save(carPort);

        if (save) {
            model.addAttribute("message", "添加成功");
        } else {
            model.addAttribute("message", "添加失败");
        }

        return prefix + "car-add";
    }

    /**
     * @Description: 订单查询
     * @Param: [page, limit, cname, crent, status]
     * @return: com.li.car.dto.PageDto<com.li.car.entity.Corder>
     */
    @GetMapping("/order")
    @ResponseBody
    public PageDto<Corder> orderList(String page, String limit, String cname, String crent, String status) {

        Utils.printMsg("AdminController->orderList:cname", cname);
        Utils.printMsg("AdminController->orderList:crent", crent);
        Utils.printMsg("AdminController->orderList:status", status);


        //根据条件 查看订单
        Page<Corder> orderPage = corderService.page(new Page<Corder>(Long.parseLong(page), Long.parseLong(limit)),
                Wrappers.<Corder>lambdaQuery().like(!StringUtils.isEmpty(cname), Corder::getCname, cname)
                        .like(!StringUtils.isEmpty(crent), Corder::getCrent, crent)
                        .eq(!StringUtils.isEmpty(status), Corder::getStatus, status));

        PageDto<Corder> dto = new PageDto<>();
        dto.setCode(0L);
        dto.setCount(orderPage.getTotal());
        dto.setData(orderPage.getRecords());
        return dto;
    }


}
