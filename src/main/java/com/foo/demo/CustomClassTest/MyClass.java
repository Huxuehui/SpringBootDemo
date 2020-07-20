package com.foo.demo.CustomClassTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyClass {
    @Value("${myParam.myClass.title}")
    private String title;

    @Value("${myParam.myClass.content}")
    private  String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "myClass{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
