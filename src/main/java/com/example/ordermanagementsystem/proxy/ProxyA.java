package com.example.ordermanagementsystem.proxy;

import java.util.Locale;

public class ProxyA extends ClassA {

    private ClassA realObject;

    public ProxyA(ClassA realObject) {
        this.realObject = realObject;
    }

    @Override
    public String greeting(String name) {
        System.out.println("Log the input: " + name);
        if (name == null) {
            return "Unknown";
        }

        name = name.toLowerCase();
        var response = realObject.greeting(name);

        return response.toLowerCase(Locale.ROOT);
    }

}
