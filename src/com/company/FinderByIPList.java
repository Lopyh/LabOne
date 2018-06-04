package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinderByIPList {
    public static PathElement findForOneStep(PathElement startElement, PathElement finishElement, List<PathElement> linkedList){
        int numberOfConnections = startElement.getConnections().size();
//        System.out.println(numberOfConnections);
//        System.out.println("Лист зашедший в find" + linkedList);
//        System.out.println("Возможно подключение к " + startElement.getConnections());
        for (PathElement p1: startElement.getConnections()
                ) {
//            System.out.println("p1 = " + p1);
            if(p1==finishElement){
//                System.out.println("v true");
                List<PathElement> list = new ArrayList<>();
                list.addAll(linkedList);
                list.add(p1);
                System.out.println("Возможный путь!!!!!!!!!!!! - " + list);
                double sum = 0;
                double delay = 0;
                for (PathElement e: list
                        ) {
                    sum+=e.getCosts();
                    delay+=e.getTimeDelay();
                }
                System.out.println("Стоимость прохода = " + sum);
                System.out.println("Число узлов = " + list.size());
                System.out.println("Задержка во времени = " + delay);
            }
            else {
//                System.out.println("v else");
                if (!linkedList.contains(p1)){
                    List<PathElement> list = new ArrayList<>();
                    list.addAll(linkedList);
                    list.add(p1);
                    findForOneStep(p1, finishElement, list);
                }
            }
        }

        return finishElement;
    }

    public static void getRoute(Network network, Integer startId, Integer finishId){
        PathElement startElement = network.getPathElements().get(startId.toString());
//        System.out.println("Начал с элемента " + startElement);
        PathElement finishElement = network.getPathElements().get(finishId.toString());
//        System.out.println("Найти элемент " + finishElement);
        List<PathElement> linkedList = new LinkedList();
        linkedList.add(startElement);
        findForOneStep(startElement, finishElement, linkedList);
    }
}
