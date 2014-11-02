package com.sellandb;

import java.util.Random;

/**
 * Created by sellandb on 11/2/14.
 */
public class Philosopher extends Thread {
    private Chopstick left, right;
    private Random random;
    private String name;

    public Philosopher(Chopstick left, Chopstick right, String pName){
        name = pName;
        this.left = left; this.right = right;
        random = new Random();
    }

    public void run () {
        try {
            while(true){
                System.out.println(name + " starts thinking");
                Thread.sleep(random.nextInt(10));
                System.out.println(name + " finished thinking");
                System.out.println(name + " attempts to pick up left Chopstick");
                synchronized (left){
                    System.out.println(name + " attempts to pick up right Chopstick");
                    synchronized (right){
                        System.out.println(name + " starts eating");
                        Thread.sleep(random.nextInt(10));
                        System.out.println(name + " finishes eating");
                    }
                }
            }
        }
        catch (InterruptedException e){

        }
    }

    public static void main(String[] args){
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();
        Chopstick c3 = new Chopstick();
        Chopstick c4 = new Chopstick();
        Chopstick c5 = new Chopstick();


        Philosopher p1 = new Philosopher(c1, c2, "P1");
        Philosopher p2 = new Philosopher(c2, c1, "P2");
        //Philosopher p3 = new Philosopher(c3, c4, "P3");
        //Philosopher p4 = new Philosopher(c4, c5, "P4");
        //Philosopher p5 = new Philosopher(c5, c1, "P5");

        p1.start();p2.start();//p3.start();p4.start();p5.start();

    }
}
