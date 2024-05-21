package org.example;

public class testBall {
    public static void main(String[] args) {
        ball b1 = new ball(5.3,1.1);
        ball b2 = new ball();

        System.out.println(b1.getX() + " | " + b1.getY());
        System.out.println(b2.getX() + " | " + b2.getY());

        b1.setX(5.6);
        b2.setXY(4.6, 2.0);

        System.out.println(b1 + "\n" + b2);

        b1.move(2.0, 1.0);
        System.out.println("\n" + b1);
    }
}