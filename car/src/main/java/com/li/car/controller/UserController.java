package com.li.car.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.li.car.entity.CarPort;
import com.li.car.entity.Corder;
import com.li.car.entity.User;
import com.li.car.services.impl.CarPortServiceImpl;
import com.li.car.services.impl.CorderServiceImpl;
import com.li.car.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 16:37
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private String prefix = "user/";

    @Autowired
    private CarPortServiceImpl carPortService;

    @Autowired
    private CorderServiceImpl corderService;

    /**
     * @Description: 获取可用车辆
     * @Param: [model]
     * @return: java.lang.String
     */
    @GetMapping
    public String carList(Model model) {

        List<CarPort>
                list = carPortService.lambdaQuery().eq(CarPort::getStatus, 1).orderByAsc(CarPort::getCname).list();

        Utils.printMsg("UserController->carList", list);

        model.addAttribute("cars", list);

        return prefix + "car";
    }


    /**
     * @Description: 通过ajax 返回可用车辆 并排序
     * @Param: [model, sort 排序顺序]
     * @return: java.util.List<com.li.car.entity.CarPort>
     */
    @GetMapping("/{sort}")
    @ResponseBody
    public List<CarPort> ajCarList(Model model, @PathVariable("sort") String sort) {

        List<CarPort> list = null;

        if ("d".equals(sort)) {
            list = carPortService.lambdaQuery().eq(CarPort::getStatus, 1).orderByDesc(CarPort::getCrent).list();
        } else if ("a".equals(sort)) {
            list = carPortService.lambdaQuery().eq(CarPort::getStatus, 1).orderByAsc(CarPort::getCrent).list();
        } else {
            list = carPortService.lambdaQuery().eq(CarPort::getStatus, 1).orderByAsc(CarPort::getCname).list();
        }

        Utils.printMsg("UserController->ajCarList", list);

        return list;
    }

    /**
     * @Description: 根据cname 进行模糊查询
     * @Param: [cname]
     * @return: java.util.List<com.li.car.entity.CarPort>
     */
    @GetMapping("/s/{name}")
    @ResponseBody
    public List<CarPort> getListByName(@PathVariable("name") String cname) {
        Utils.printMsg("UserController->getListByName->cname", cname);

        return carPortService.lambdaQuery().like(CarPort::getCname, cname).list();
    }

    /**
     * @Description: 根据cid 查看车辆详情
     * @Param: [cname]
     * @return: java.util.List<com.li.car.entity.CarPort>
     */
    @GetMapping("/o/{cid}")
    public String orderByCid(@PathVariable("cid") String cid, Model model) {
        Utils.printMsg("UserController->orderByCid->cid", cid);

        CarPort car = carPortService.getOne(Wrappers.<CarPort>lambdaQuery().eq(CarPort::getCid, cid));

        Calendar ca = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd mm:ss");
        String takeTime = formatter.format(new Date());

        ca.add(Calendar.DATE, 2);
        String getTime = formatter.format(ca.getTime());
        model.addAttribute("getTime", getTime);
        model.addAttribute("takeTime", takeTime);

        model.addAttribute("car", car);

        return prefix + "user-order";
    }

    /**
     * @Description: 添加订单
     * @Param: [order]
     * @return: java.lang.Boolean
     */
@PostMapping("/order")
@ResponseBody
public Boolean addOrder(Corder order) {

    User user = Utils.securityUser();

    Utils.printMsg("UserController->addOrder->user:", user);

    String uid = user.getUid();

    Utils.printMsg("UserController->addOrder->corder:", order);
    order.setUid(uid);

    return corderService.addOrder(order);
}

    /**
     * @Description: 获取用户订单
     * @Param: [model]
     * @return: java.lang.Object
     */
@GetMapping("/order/{status}")
public Object getOrder(Model model, @PathVariable("status") String status) {
    User user = Utils.securityUser();

    List<Corder> list = corderService.lambdaQuery().eq(Corder::getUid, user.getUid()).eq(Corder::getStatus, status).list();
    model.addAttribute("list", list);
    if (status.equals("1")) {
        return prefix + "uorder";
    } else {
        return prefix + "uorder-history";
    }

}

    /**
     * @Description: 还车
     * @Param: [oid, cid]
     * @return: java.lang.Object
     */
    @GetMapping("/order/status")
    @ResponseBody
    public Object updateStatus(String oid, String cid) {
        return corderService.getCar(oid, cid);
    }


}
