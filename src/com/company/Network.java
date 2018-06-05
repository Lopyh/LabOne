package com.company;





import com.company.active.Firewall;
import com.company.active.PC;
import com.company.active.Router;
import com.company.active.Switch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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

    @XmlElements({
            @XmlElement(name = "PC", type = PC.class),
            @XmlElement(name = "Router", type = Router.class),
            @XmlElement(name = "Switch", type = Switch.class),
            @XmlElement(name = "Firewall", type = Firewall.class)
    })
    public HashMap<String, ActiveElement> getPathElements() {
        return pathElements;
    }
}
