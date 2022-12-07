package com.hvs.basics.principal;

public class TestingService implements ITesting {
    @Override
    public void print(String value) {
        System.out.println(value);
    }

    @Override
    public void printV2(String value) {
        System.out.println("From Class: " + value);
    }
}
