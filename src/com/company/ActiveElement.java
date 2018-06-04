package com.company;


import com.company.active.Firewall;
import com.company.active.PC;
import com.company.active.Router;
import com.company.active.Switch;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"ID", "IP", "timeDelay", "costs", "info", "listIP", "name"})
@XmlSeeAlso({PC.class,Router.class,Switch.class,Firewall.class})
public abstract class  ActiveElement <T extends ActiveElement> implements PathElement, Serializable{


    String name = this.getClass().getName();

    @XmlElement
    public String getName() {
        return name;
    }

    private String IP;
    private double timeDeleay;
    private double costs;
    private Collection<ActiveElement> connections = new ArrayList<>();
    public Collection<String> listIP =  new ArrayList<>();
    private String info;
    private Integer id;


    @XmlElement
    public Collection<String> getListIP() {
        return listIP;
    }

    public void setListIP(Collection<String> listIP) {
        this.listIP = listIP;
    }

    public ActiveElement() {
    }

    public void setConnection(T connection) {
        connections.add(connection);
        listIP.add(connection.getIP());
        connection.getConnections().add(this);
        connection.listIP.add(this.getIP());
    }


    @XmlElement
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
    @XmlElement
    public double getTimeDelay() {
        return timeDeleay;
    }

    @Override
    @XmlElement
    public double getCosts() {
        return costs;
    }


    @Override
    @XmlElement
    public String getInfo() {
        return info;
    }

    public void setConnections(Collection<ActiveElement> connections) {
        this.connections = connections;
    }

    @Override
    public Collection<ActiveElement> getConnections() {
        return connections;
    }

    @Override
    @XmlElement
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
