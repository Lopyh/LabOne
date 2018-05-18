package com.company;

import java.util.Collection;

public class ActiveElement implements PathElement{
    @Override
    public double getTimeDelay() {
        return 0;
    }

    @Override
    public double getCosts() {
        return 0;
    }

    @Override
    public Collection<PathElement> getConnections() {
        return null;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Integer getID() {
        return null;
    }
}
