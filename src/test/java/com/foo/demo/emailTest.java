package com.foo.demo;

import com.foo.demo.email.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class emailTest {

  @Autowired
  private EmailService MailService;

  @Test
  public void testSimpleMail() throws Exception {
    MailService.sendSimpleMail(
        "1716396045@qq.com", "test simple mail", " hello this is simple mail");
  }
}
