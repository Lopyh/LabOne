package com.company.serialization;

import com.company.ActiveElement;
import com.company.PathElement;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;

public class MapAdapter extends XmlAdapter<ActiveElement[], HashMap<String, PathElement>> {

    @Override
    public HashMap<String, PathElement> unmarshal(ActiveElement[] v) throws Exception {
        return null;
    }

    @Override
    public ActiveElement[] marshal(HashMap<String, PathElement> v) throws Exception {
        ActiveElement[] list = new ActiveElement[v.size()];
        int i = 0;
        for (HashMap.Entry<String, PathElement> e: v.entrySet()
             ) {
            list[i++]= (ActiveElement) e.getValue();
        }
        return list;
    }
}
