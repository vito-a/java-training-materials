package org.example.points;

public class Point1D {
    private int x;
    public Point1D(int x) {
        this.x = x;
    }

    public Point1D() {

    }

    public double length() {
        return Math.abs(x);
    }
    @Override
    public String toString() {
        return " x=" + x;
    }
    void setX(int x) {
        this.x = x;
    }
}