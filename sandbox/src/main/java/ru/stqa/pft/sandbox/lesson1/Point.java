package ru.stqa.pft.sandbox.lesson1;

public class Point {

    public double x;
    public double y;

    //конструктор
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point toPoint)
    {
        double l;

        l = Math.sqrt(Math.pow(toPoint.x - this.x, 2) + Math.pow(toPoint.y - this.y, 2));

        return l;
    }

}
