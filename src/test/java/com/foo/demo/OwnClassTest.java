package com.foo.demo;

import com.foo.demo.CustomClassTest.MyClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OwnClassTest {

    @Autowired
    private MyClass own;

    @Test
    public void ownTest(){
        String content = own.getContent();
        System.out.println(content);
    }
}
