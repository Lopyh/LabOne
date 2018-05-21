package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class ActiveElement implements PathElement{
    private String IP;
    private double timeDeleay;
    private double costs;
    private Collection<PathElement> connections = new ArrayList<>();
    Collection<String> listIP =  new ArrayList<>();
    private String info;
    private Integer id;

    public void setConnection(ActiveElement connection) {
        connections.add(connection);
        listIP.add(connection.getIP());
        connection.connections.add(this);
        connection.listIP.add(this.getIP());
    }

    public void setConnection(PassiveElement connection) {
        connections.add(connection);
    }

    public String getIP() {
        return IP;
    }

    public ActiveElement(double timeDeleay, double costs, String info, Integer id, String ip) {
        this.timeDeleay = timeDeleay;
        this.costs = costs;
        this.info = info;
        this.id = id;
        this.IP = ip;
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

    @Override
    public String toString() {
        return "ActiveElement{" +
                "IP='" + IP + '\'' +
                ", id=" + id +
                '}';
    }
}
