package com.company.serialization;



import java.io.*;

public class SerializationFile {
    public static <T> void toFile(T network) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("network.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(network);
        outputStream.flush();
        outputStream.close();
    }

    public static <T> T fromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T ts = (T) objectInputStream.readObject();
        return ts;
    }
}
