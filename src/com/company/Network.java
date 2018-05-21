package com.company;

import java.util.HashMap;

public class Network {

    private HashMap<String, PathElement> pathElements =  new HashMap<>();

    public void setPathElement(PathElement pathElement) {
        this.pathElements.put(pathElement.getID().toString(), pathElement);
    }

    public HashMap<String, PathElement> getPathElements() {
        return pathElements;
    }
}
