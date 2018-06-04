package com.company.active;

import com.company.ActiveElement;
import com.company.PathElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;


@XmlRootElement(name = "Router")
public class Router extends ActiveElement implements Serializable {

    public Router() {
    }

    public Router(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }
}
