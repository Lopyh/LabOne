package com.company;

import java.util.List;

public interface RouteProvider {
    List<PathElement> getRoute(Integer firstID, Integer secondID, Network net) throws RouterNotFoundException;
    String getDiscription();
}
