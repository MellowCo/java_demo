package com.li.redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-02 09:32
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/sendcode")
    public Object sendCode(String phone_no) {
        String codeKey = phone_no + ":code";
        String codeCount = phone_no + ":count";

        String s = template.opsForValue().get(codeCount);

        //限制发送的次数
        if (s == null) {
            template.opsForValue().set(codeCount, "1", 1, TimeUnit.DAYS);
        } else if (Integer.parseInt(s) < 3) {
            template.opsForValue().increment(codeCount);
        } else {
            return "limit";
        }

        //生成随机数
        String code = "";
        for (int i = 0; i < 6; i++) {
            int code1 = new Random().nextInt(10);
            code += code1;
        }

        //设置有效时间为60秒
        template.opsForValue().set(codeKey, code, 60, TimeUnit.SECONDS);
        return true;
    }

    @RequestMapping("/getCode")
    public Object getCode(String verify_code, String phone_no) {
        String codeKey = phone_no + ":code";

        //获取key的过期时间，-2位过期
        Long expire = template.getExpire(codeKey);

        System.out.println("过期时间：" + expire);

        if (expire == -2) {
            System.out.println("redis 过期");
            return null;
        }

        //获取redis中的验证码
        String code = template.opsForValue().get(codeKey);

        System.out.println("reids code =" + code + ",verify_code=" + verify_code);

        if (code.equals(verify_code)) {
            return "true";
        } else {
            return "false";
        }

    }

}
