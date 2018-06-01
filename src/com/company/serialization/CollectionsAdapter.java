package com.company.serialization;

import com.company.ActiveElement;
import com.company.PathElement;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionsAdapter extends XmlAdapter<ArrayList<ActiveElement>, Collection<PathElement>> {

    @Override
    public Collection<PathElement> unmarshal(ArrayList<ActiveElement> v) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ActiveElement> marshal(Collection<PathElement> v) throws Exception {
        ArrayList<ActiveElement> collection = new ArrayList<>();
        v.stream().forEach(System.out::println);
        System.out.println("====================");
        v.stream().forEach(a -> collection.add((ActiveElement) a));
        return collection;
    }
}
