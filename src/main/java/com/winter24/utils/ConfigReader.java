package com.winter24.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private ConfigReader () { // приватный конструктор
        //Singleton pattern -Одиночный шаблон

    }
    static { //статичный блок все в этом теле будут статичными
        try {
            String path="src/main/resources/add.properties";
            FileInputStream fileInputStream= new FileInputStream(path); // через этот класс можно брать доступ к файлам
            properties= new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getValue (String key) {

        return properties.getProperty(key).trim();
    }

    public static void main(String[] args) {
        System.out.println(getValue("browser"));
        System.out.println(getValue("userName"));
        System.out.println(getValue("password"));

    }
}