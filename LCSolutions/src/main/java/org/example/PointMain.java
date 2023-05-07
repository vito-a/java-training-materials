package org.example;

public class PointMain {
    public PointMain() {
        Point1D point1 = new Point1D();
        point1.setX(3);
        System.out.println(point1.length());
        Point1D point2 = new Point2D();
        point2.setX(3);
        ((Point2D) point2).setY(4);
        System.out.println(point2.length());
    }
}
