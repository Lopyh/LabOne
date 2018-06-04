package com.company.active;

import com.company.ActiveElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement
@XmlType(propOrder = {"pcName"})
public class PC extends ActiveElement implements Serializable{


    private String pcName =  "Intel Core i7";

    @XmlElement
    public String getPcName() {
        return pcName;
    }

    public PC() {
    }

    public PC(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }

}
