package com.mypack;

public class Test04 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        double area = circle.getArea(2);
        System.out.println("圆的面积是："+area);
    }
}
class Circle{
    private double r;
    public static final double PI = 3.14;
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    public double getArea(double r) {
        return r * PI;
    }

}