package com.company;

import java.util.Collection;

public abstract class PassiveElement implements PathElement{
    private double timeDeleay;
    double costs;
    Collection<PathElement> connections;
    String info;
    Integer id;



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
        return id;
    }
}
