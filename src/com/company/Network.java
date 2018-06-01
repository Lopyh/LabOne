package com.company;



import com.company.serialization.MapAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.HashMap;

@XmlRootElement
public class Network implements Serializable{
    private HashMap<String, PathElement> pathElements =  new HashMap<>();

    public void setPathElement(PathElement pathElement) {
        this.pathElements.put(pathElement.getID().toString(), pathElement);
    }


    @XmlJavaTypeAdapter(MapAdapter.class)
    public HashMap<String, PathElement> getPathElements() {
        return pathElements;
    }
}
