package com.company.active;

import com.company.ActiveElement;
import com.company.PathElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@XmlRootElement(name = "Switch")
public class Switch extends ActiveElement implements Serializable {

    public Switch(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }
}
