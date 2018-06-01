package com.company;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;



public interface PathElement {
    double getTimeDelay();
    double getCosts();
    Collection<PathElement> getConnections();
    String getInfo();
    Integer getID();


}
