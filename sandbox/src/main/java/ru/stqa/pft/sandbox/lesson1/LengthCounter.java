package ru.stqa.pft.sandbox.lesson1;

public class LengthCounter {

    public static void main(String[] args){
        //расчет с помощью функции
        Point start = new Point(-4, 2);
        Point finish = new Point(5, -3);

        double roadLength = distanceStatic(start, finish);

        System.out.println("Расчет через функцию");
        System.out.println("Расстояние между точками с координатами [" + start.x + ", " + start.y + "] и [" + finish.x + ", " + finish.y + "] равно: " + roadLength);

        //расчет через метод класса Point
        //те же координаты
        start = new Point(-4, 2);
        finish = new Point(5, -3);

        roadLength = start.distanceTo(finish);

        System.out.println("Расчет через метод класса Point");
        System.out.println("Расстояние между точками с координатами [" + start.x + ", " + start.y + "] и [" + finish.x + ", " + finish.y + "] равно: " + roadLength);
        //другие координаты
        start = new Point(0, 3);
        finish = new Point(1, 2);

        roadLength = start.distanceTo(finish);

        System.out.println("Расстояние между точками с координатами [" + start.x + ", " + start.y + "] и [" + finish.x + ", " + finish.y + "] равно: " + roadLength);
        // расчет через метод другого класса, если объекты Point нужно определять отдельно

      /*  start = new Point(-3, 2);
        finish = new Point(5, -3);

        DistanceTwoPoints roadLengthClass = new DistanceTwoPoints(start, finish);
        roadLength = roadLengthClass.distance();

        System.out.println("Расчет через метод класса");
        System.out.println("Расстояние между точками с координатами [" + start.x + ", " + start.y + "] и [" + finish.x + ", " + finish.y + "] равно: " + roadLength);
*/

    }

    /* функция в запускаемом классе */
    private static double distanceStatic(Point p1, Point p2) {

        double l;
        l = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));

        return l;
    }


}

