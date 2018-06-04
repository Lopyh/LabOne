package com.company;





import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.HashMap;

@XmlRootElement
public class Network implements Serializable{
    private HashMap<String, ActiveElement> pathElements =  new HashMap<>();

    public void setPathElement(ActiveElement pathElement) {
        this.pathElements.put(pathElement.getID().toString(), pathElement);
    }

    @XmlElement
    public HashMap<String, ActiveElement> getPathElements() {
        return pathElements;
    }
}
