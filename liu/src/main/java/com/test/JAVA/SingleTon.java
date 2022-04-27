package com.test.JAVA;


/**
 * 单例模式
 */
public class SingleTon {
    private static SingleTon instance = new singleTon();

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return instance;
    }
}