package com.company.serialization;

import com.company.ActiveElement;
import com.company.Network;
import javafx.print.Collation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class XMLFile {

    public static Network fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Network.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            Network  net = (Network) un.unmarshal(new File(filePath));
            HashMap<String, ActiveElement> list = new HashMap<>();

            for (HashMap.Entry<String,ActiveElement> e: net.getPathElements().entrySet()
                    ) {
                list.put(e.getValue().getIP(), e.getValue());
            }

            for (HashMap.Entry<String,ActiveElement> e: net.getPathElements().entrySet()
                    ) {
                for (String s: (Collection<String>)e.getValue().getListIP()
                     ) {
                    System.out.println(s);
//                    e.getValue().setConnection(list.get(s));
                }
            }


            return net;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void convertObjectToXml(Network network, String fileName) throws JAXBException {
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
