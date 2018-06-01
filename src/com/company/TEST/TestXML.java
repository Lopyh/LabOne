package com.company.TEST;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestXML {
    private static HashMapTest fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(HashMapTest.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (HashMapTest) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void convertObjectToXml(HashMapTest network, String fileName) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(HashMapTest.class);
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
