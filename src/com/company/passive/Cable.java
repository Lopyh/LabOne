package com.company.passive;

import com.company.ActiveElement;
import com.company.PassiveElement;

import java.util.Collection;

public class Cable extends PassiveElement {

    @Override
    public Collection<ActiveElement> getConnections() {
        return null;
    }
}
