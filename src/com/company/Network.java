package com.company;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;


@XmlRootElement(name = "Network")
public class Network implements Serializable{


    private HashMap<String, PathElement> pathElements =  new HashMap<>();

    public void setPathElement(PathElement pathElement) {
        this.pathElements.put(pathElement.getID().toString(), pathElement);
    }

    public HashMap<String, PathElement> getPathElements() {
        return pathElements;
    }
}
