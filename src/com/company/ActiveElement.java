package com.company;

import com.company.serialization.CollectionsAdapter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement
public abstract class  ActiveElement <T extends ActiveElement> implements PathElement, Serializable{

    private String IP;
    private double timeDeleay;
    private double costs;
    private Collection<PathElement> connections = new ArrayList<>();
    Collection<String> listIP =  new ArrayList<>();
    private String info;
    private Integer id;

    public ActiveElement() {
    }

    public void setConnection(T connection) {
        connections.add(connection);
        listIP.add(connection.getIP());
        connection.getConnections().add(this);
        connection.listIP.add(this.getIP());
    }

    public void setConnection(PassiveElement connection) {
        connections.add(connection);
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
    @XmlJavaTypeAdapter(CollectionsAdapter.class)
    public Collection<PathElement> getConnections() {
        return connections;
    }

    @Override
    @XmlElement
    public String getInfo() {
        return info;
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
