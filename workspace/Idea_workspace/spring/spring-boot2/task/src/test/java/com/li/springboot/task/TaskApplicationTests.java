package com.li.springboot.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void send(){
        //发送的邮箱
        SimpleMailMessage message = new SimpleMailMessage();

        //邮件标题
        message.setSubject("这是标题");
        //邮件内容
        message.setText("发送成功");

        //设置发送给
        message.setTo("361209603@qq.com");
        //设置发送方
        message.setFrom("799478052@qq.com");
        //发送
        mailSender.send(message);
    }

    @Test
    public void send2() throws MessagingException {
        //创建复杂邮件
        MimeMessage message = mailSender.createMimeMessage();
        //传入MimeMessage,是否上传文件
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        //设置邮件
        helper.setSubject("这是带附件的邮件");
        //true:转换成html
        helper.setText("<b style='color:red'>邮件</b>",true);

        helper.setTo("361209603@qq.com");
        helper.setFrom("799478052@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("F:\\系统\\桌面\\images\\438211.jpg"));

        mailSender.send(message);
    }

}
