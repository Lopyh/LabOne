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
@XmlType(propOrder = {"ID", "IP", "timeDelay", "costs", "info", "listIP"})
@XmlSeeAlso({PC.class,Router.class,Switch.class,Firewall.class})
public abstract class  ActiveElement <T extends ActiveElement> implements PathElement, Serializable{

    @XmlElement
    private String IP;
    @XmlElement
    private double timeDelay;
    @XmlElement
    private double costs;
    private Collection<ActiveElement> connections = new ArrayList<>();
    @XmlElement
    private Collection<String> listIP =  new ArrayList<>();
    @XmlElement
    private String info;
    @XmlElement
    private Integer ID;

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
        connection.getListIP().add(this.getIP());
    }


    public String getIP() {
        return IP;
    }

    public ActiveElement(double timeDelay, double costs, String info, Integer ID, String ip) {
        this.timeDelay = timeDelay;
        this.costs = costs;
        this.info = info;
        this.ID = ID;
        this.IP = ip;
    }

    @Override
    public double getTimeDelay() {
        return timeDelay;
    }

    @Override
    public double getCosts() {
        return costs;
    }


    @Override
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
    public Integer getID() {
        return ID;
    }



    @Override
    public String toString() {
        return "ActiveElement{" +
                "IP='" + IP + '\'' +
                ", id=" + ID +
                '}';
    }
}
