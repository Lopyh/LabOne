package com.company.active;

import com.company.ActiveElement;
import com.company.PathElement;

import java.io.Serializable;
import java.util.Collection;

public class Firewall extends ActiveElement implements Serializable {

    public Firewall(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }
}
