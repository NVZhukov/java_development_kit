package ru.gb.lesson5;

public class Philosopher extends Thread{
    private String name;
    private Object leftFork;
    private Object rightFork;
    private int satiety;

    public Philosopher(String name, Object leftFork, Object rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doIt(String action) throws InterruptedException {
        System.out.println(name + " " + action);
        Thread.sleep((int)(Math.random() * 100));
    }

    @Override
    public void run() {
        try {
            while (satiety < 3){
                doIt("Thinking");
                synchronized (leftFork) {
                    doIt("Pick up left fork");
                    synchronized (rightFork) {
                        doIt("Pick up right fork - eat!");
                        doIt("Put down right fork");
                    }
                    doIt("Put down left fork. Back to thinking");
                    satiety++;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
