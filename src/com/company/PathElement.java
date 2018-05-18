package com.company;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public interface PathElement {
    double getTimeDelay();
    double getCosts();
    Collection<PathElement> getConnections();
    String getInfo();
    Integer getID();


}
