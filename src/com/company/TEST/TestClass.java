package com.company.TEST;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestClass implements TestIntarface{
    @XmlElement
    int a;

    @Override
    public void getYA() {
        System.out.println("Ya");
    }

    public TestClass() {
    }

    public TestClass(int a) {
        this.a = a;
    }
}
