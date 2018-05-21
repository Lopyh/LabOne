package com.company;

public class RouterNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Не нашел такую точку соединения";
    }
}
