package com.foo.demo.dao;

import com.foo.demo.model.User;
//@Test有两个包，一个是org.junit.jupiter.api.Test，另一个是org.junit.Test，而测试需要的Junit是org.junit.Test
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UerDaoTest {

  @Autowired
  private UserDao dao;

  @Test
  public void findByUserName() {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
    String formattedDate = dateFormat.format(date);
    User u = new User();
    u.setEmail("aaa@qq.com");
    u.setNickName("hxh");
    u.setPassWord("123456");
    u.setRegTime(date);
    u.setUserName("hu");
    u.setId(1L);
    dao.save(u);
    User hu = dao.findByUserName("hu");
    String hu1 = dao.findByUserName("hu").getNickName();
    System.out.println(hu.toString());
    System.out.println(hu1);
  }

  @Test
  public void findByNameOrNickName() {}
}