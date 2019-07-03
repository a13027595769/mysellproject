package com.mypack;

public class Test07 {
    public static void main(String[] args) {
        Point point = new Point();
        point.setPoint(10,20);
        System.out.println("x="+point.getX());
        System.out.println("y="+point.getY());
        String abcTMD = MD5.encode("abcTMD123");
        System.out.println(abcTMD);

    }
}
class Point{
    private int x;

    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setPoint(int x, int y){
       this.x = x;
       this.y = y;
    }
}
