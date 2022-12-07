package com.hvs.basics.principal;

public interface ITesting {

    public String NAME = "vehicle";

    void print(String value);


    default void printV2(String value) {
        System.out.println("From Interface: " + value);
    }


}
