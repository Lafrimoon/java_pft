package ru.stqa.pft.sandbox.lesson1;

public class DistanceTwoPoints {

    public Point p1;
    public Point p2;

    public double distance() {

        double l;

        l = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));

        return l;
    }

    public DistanceTwoPoints(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

}
