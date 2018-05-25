package com.company.active;

import com.company.ActiveElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "PC")
public class PC extends ActiveElement implements Serializable{
    public PC(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }



}
