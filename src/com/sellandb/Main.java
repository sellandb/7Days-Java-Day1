package com.sellandb;


public class Main {
    static boolean answerReady = false;
    static int answer = 0;
    static Thread t1 = new Thread () {
        public void run() {
            answer = 42;
            answerReady = true;
        }
    };

    static Thread t2 = new Thread(){
        public void run (){
            if (answerReady){
                System.out.println("The meaning of life is: " + answer);
            }
            else{
                System.out.println("I don't know the answer");
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        t1.start();t2.start();
        t1.join();t2.join();
    }


}


//Demo 2
/*
public class Main {

    public static void main(String[] args) throws InterruptedException{
        class Counter {
            private int count = 0;
            public void increment() { ++count; }
            public int getCount() {return count; }
        }

        final Counter counter = new Counter();
        class CountingThread extends Thread {
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();

        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(counter.getCount());
    }
}*/

//Demo 1
/*
public class Main {

    public static void main(String[] args) throws InterruptedException{
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("Hello World from My Thread");
            }
        };

        myThread.start();
        //Thread.yield();
        Thread.sleep(1);
        System.out.println("Hello World from the Main Thread");
        myThread.join();
	// write your code here
    }
}*/
