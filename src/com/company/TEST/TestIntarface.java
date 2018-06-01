package com.company.TEST;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;


public interface TestIntarface {
    @XmlElement(type=TestClass.class)
    void getYA();
}
