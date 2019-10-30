package com.company;

public class Pra2 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.setColor("red");
        cylinder.setHeight(4.5);
        cylinder.setRadius(6.6);
        cylinder.volume();
    }
}

interface A {
    double PI = 3.14;
    double area();
}

interface B {
    void setColor(String c);
}

interface C extends A,B{
    void volume();
}

class Cylinder implements C{
    private double radius;
    private double height;
    private String color;
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return PI*Math.pow(radius,2);
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }

    @Override
    public void volume() {
        System.out.println("volume: "+this.area()*this.height);
    }
}