package com.company.TEST;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement
public class HashMapTest {



    public HashMap<TestIntarface, String> hashMap = new HashMap<>();

    public String asd;

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
