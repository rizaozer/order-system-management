package com.example.ordermanagementsystem.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Locale;

public class Runner {

    public static void main(String[] args) {

        InterfaceA realObject = getClassA();

        var r = realObject.greeting("MARCO");

        System.out.println(r);
    }

    private static InterfaceA getClassA() {
        return (InterfaceA) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{InterfaceA.class},
                new InvocationHandler() {
                    private final ClassA realObject = new ClassA();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("greeting")) {
                            System.out.println("Log the input: " + args[0]);
                            if (args[0] == null) {
                                return "Unknown";
                            }

                            args[0] = ((String) args[0]).toLowerCase();
                            var response = method.invoke(realObject, args);

                            return ((String) response).toLowerCase(Locale.ROOT);
                        }
                        return method.invoke(realObject, args);
                    }
                }
        );
    }

}
