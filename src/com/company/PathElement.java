package com.company;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.Collection;


public interface PathElement {
    double getTimeDelay();
    double getCosts();
    Collection<PathElement> getConnections();
    String getInfo();
    Integer getID();


}
