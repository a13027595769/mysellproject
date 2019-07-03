package com.mypack;

public class Test05 {
    public static void main(String[] args) {
        Apple apple = new Apple();
    }
}

class Fruit{
    public Fruit() {
        System.out.println("父类构造器被调用");
    }
}
class Apple extends Fruit{
    public Apple() {
        super();
        System.out.println("子类构造器被调用");
    }
}
