package com.home.thread;

/**
 * Simple class to demonstrate
 * 1.
 * The joining of user created thread.
 * Once you say join , the main thread will join after the execution
 * of the joining thread..
 * If you are not joining with main , the main finishes its execution
 * without waiting for the user threads..
 *
 * 2. The Daemon thread,
 * If you mention a thread as daemon thread,
 * it terminates execution when the main thread finishes its execution.
 * This is a problem , keep any as deamon thread, only if you dont want that thread
 * to continue execution when the main is terminated
 *
 */
public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.threadCaller();
        System.out.println("Main completed..");
    }

    public void threadCaller(){
        Thread thread = new Thread(()->printNumbers());
        Thread threadDaemon = new Thread(()->printNumbersByDaemon());
        threadDaemon.setDaemon(true);
        thread.start();
        threadDaemon.start();
        try {

            thread.join();
            threadDaemon.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void printNumbers(){
        for (int i = 0; i < 2 ; i++) {
            System.out.println("Number is ="+i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Normal thread completed");
    }

    private void printNumbersByDaemon(){
        for (int i = 0; i < 2 ; i++) {
            System.out.println("By daemon ,Number is ="+i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Daemon thread completed");
    }


}
