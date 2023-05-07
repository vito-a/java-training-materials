package org.example;

public class QuadraticEquation {
    public Roots findRoots(double a, double b, double c) {
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        return new Roots(x1, x2);
    }

    public void ListSolution() {
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        Roots roots = quadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }

    class Roots {
        public final double x1, x2;

        public Roots(double x1, double x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}
