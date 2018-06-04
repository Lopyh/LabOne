package com.company;

import com.company.TEST.HashMapTest;
import com.company.TEST.TestClass;
import com.company.TEST.TestIntarface;
import com.company.TEST.TestXML;

import com.company.active.Firewall;
import com.company.active.PC;
import com.company.active.Router;
import com.company.active.Switch;
import com.company.serialization.XMLFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;


public class Creator {

    /**public PC(double timeDeleay, double costs, String info, Integer id, String ip)*/
    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        ActiveElement pc1 = new PC(100.0, 5.0, "First PC", 1, "192.168.0.0");
        ActiveElement router1 =  new Router(50.0, 10.0, "Router1", 2, "192.168.0.1");
        ActiveElement switch1 = new Switch(60.0, 8.0, "Switch 1", 3, "192.168.0.2");
        ActiveElement firewall = new Firewall(200.0, 15.0, "First firewall", 4, "192.168.0.3");
        ActiveElement pc2 = new PC(50.0, 30.0, "PC 2", 5, "192.168.0.4");
        ActiveElement pc3 = new PC(30.0, 10.0, "PC 3", 6, "192.168.0.5");
        ActiveElement router2 = new Router(30.0, 20.0, "PC 3", 7, "192.168.0.5");


        //Схема подключения
        //(4)Firewall ---- (1)PC1
        //    |             |
        //    |             |
        //(2)Router1 ------ (3)Switch1----(6)PC3
        //                   |              |
        //                   |              |
        //                 (5)PC2 -------(7)Router2

        ((Switch) switch1).setConnection((ActiveElement) pc2);
        ((PC) pc1).setConnection((ActiveElement) firewall);
        ((PC) pc1).setConnection((ActiveElement) switch1);
        ((Firewall) firewall).setConnection((ActiveElement) router1);
        ((Router) router1).setConnection((ActiveElement) switch1);
        ((PC) pc3).setConnection((ActiveElement) switch1);
        ((Router) router2).setConnection((ActiveElement) pc3);
        ((Router) router2).setConnection((ActiveElement) pc2);



        //Создание сети и добавление элементов в нее



        Network network = new Network();

        network.setPathElement(pc1);
        network.setPathElement(pc2);
        network.setPathElement(switch1);
        network.setPathElement(router1);
        network.setPathElement(firewall);
        network.setPathElement(pc3);
        network.setPathElement(router2);

        /**************************************************/
        /** Тут задается network, начальный и конечный ID**/
        /**************************************************/


        /**Сериализация*/
      //  SerializationFile.toFile(network);

        /**Десериализация*/
        //Network net = SerializationFile.fromFile("network.bin");

        /**Сохранение в XML*/
        String fileName = "network.xml";

//Testing
//        HashMapTest f =  new HashMapTest();
//        f.asd = "asdf";
//        f.setA(23);
//        TestClass t = new TestClass(1);
//        f.hashMap.put(t,"sdf");
//        TestXML.convertObjectToXml(f,"testXML.xml");

        XMLFile.convertObjectToXml(network, fileName);

        Network netFromXml = XMLFile.fromXmlToObject(fileName);

        for (HashMap.Entry<String,ActiveElement> e: netFromXml.getPathElements().entrySet()
                ) {
            System.out.println(e.getValue());
        }




        /**Поис пути*/
//        FinderByAllWays.getRoute(network, 4, 7);


    }
}
