package com.company.active;

import com.company.ActiveElement;
import com.company.PathElement;

import java.util.Collection;

public class Firewall extends ActiveElement {

    public Firewall(double timeDeleay, double costs, String info, Integer id, String ip) {
        super(timeDeleay, costs, info, id, ip);
    }
}
