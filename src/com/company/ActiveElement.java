package com.company;

import java.util.Collection;

public class ActiveElement implements PathElement{
    private double timeDeleay;
    double costs;
    Collection<PathElement> connections;
    String info;
    Integer id;

    public ActiveElement(double timeDeleay, double costs, Collection<PathElement> connections, String info, Integer id) {
        this.timeDeleay = timeDeleay;
        this.costs = costs;
        this.connections = connections;
        this.info = info;
        this.id = id;
    }

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
