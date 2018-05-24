package com.company;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "PassiveElement")
public abstract class PassiveElement implements PathElement{
    private double timeDeleay;
    private double costs;
    private Collection<PathElement> connections;
    private String info;
    private Integer id;



    @Override
    public double getTimeDelay() {
        return timeDeleay;
    }

    @Override
    public double getCosts() {
        return costs;
    }

    @Override
    public Collection<PathElement> getConnections() {
        return connections;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public Integer getID() {
        Integer id = this.id;
        return id;
    }
}
