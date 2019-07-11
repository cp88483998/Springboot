package com.warm.system.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.warm.system.service.IUserInfoService;

/**
 * @Author DGD
 * @date 2018/2/10.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DataTest {
    @Autowired
    private IUserInfoService userService;

    @Test
    public void test() {
        userService.getUserList().stream().forEach(item -> System.out.println(item.getUsername()));
    }

}
