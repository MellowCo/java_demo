package com.li.test;


import com.li.config.SpringConfig;
import com.li.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestProxyAccount {
    // @Autowired
    // @Qualifier("proxyAccount")
    // IAccountService service = null;

    @Autowired
    IAccountService service = null;


    // @Test
    // public void testProxy(){
    //
    //     service.deleteAccount();
    // }

    @Test
    public void testAop(){
        service.saveAccount();
    }
}
