package com.company;

import com.company.serialization.*;

import com.company.active.Firewall;
import com.company.active.PC;
import com.company.active.Router;
import com.company.active.Switch;
import sun.nio.ch.Net;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Creator {

    /**public PC(double timeDeleay, double costs, String info, Integer id, String ip)*/
    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        PathElement pc1 = new PC(100.0, 5.0, "First PC", 1, "192.168.0.0");
        PathElement router1 =  new Router(50.0, 10.0, "Router1", 2, "192.168.0.1");
        PathElement switch1 = new Switch(60.0, 8.0, "Switch 1", 3, "192.168.0.2");
        PathElement firewall = new Firewall(200.0, 15.0, "First firewall", 4, "192.168.0.3");
        PathElement pc2 = new PC(50.0, 30.0, "PC 2", 5, "192.168.0.3");

        //Схема подключения
        //(4)Firewall ---- (1)PC1
        //    |             |
        //    |             |
        //(2)Router ------ (3)Switch
        //                   |
        //                   |
        //                 (5)PC2

        ((Switch) switch1).setConnection((ActiveElement) pc2);
        ((PC) pc1).setConnection((ActiveElement) firewall);
        ((PC) pc1).setConnection((ActiveElement) switch1);
        ((Firewall) firewall).setConnection((ActiveElement) router1);
        ((Router) router1).setConnection((ActiveElement) switch1);


        //Создание сети и добавление элементов в нее

        Network network = new Network();

        network.setPathElement(pc1);
        network.setPathElement(pc2);
        network.setPathElement(switch1);
        network.setPathElement(router1);
        network.setPathElement(firewall);

        /**************************************************/
        /** Тут задается network, начальный и конечный ID**/
        /**************************************************/


        /**Сериализация*/
        SerializationFile.toFile(network);

        /**Десериализация*/
        Network net = SerializationFile.fromFile("network.bin");

        /**Сохранение в XML*/
        String fileName = "network.xml";

        convertObjectToXml(network, fileName);

        /**Поис пути*/
//        FinderByAllWays.getRoute(network, 1, 5);


    }


    private static Network fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Network.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Network) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void convertObjectToXml(Network network, String fileName) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Network.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(network, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
