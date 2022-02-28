package com.munywele;

import java.util.function.IntConsumer;

public class FizzBuzzMultiThread {
    private int n = 0;
    private int currentNumber = 1;
    private final Object mutex = new Object();

    public FizzBuzzMultiThread(int range) {
        this.n = range;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 || currentNumber % 5 != 0) {
                printFizz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 || currentNumber % 5 == 0) {
                printBuzz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }

        }
    }

    public synchronized void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                printFizzBuzz.run();
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void printNumber(IntConsumer printNumber) throws InterruptedException {
        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                printNumber.accept(currentNumber);
                currentNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        FizzBuzzMultiThread fizz = new FizzBuzzMultiThread(100);

        Runnable printFizz = () -> System.out.println("Fizz");
        Runnable printBuzz = () -> System.out.println("Buzz");
        Runnable printFizzBuzz = () -> System.out.println("FizzBuzz");
        IntConsumer printNumber = System.out::println;

        Thread t1 = new Thread(() -> {
            try {
                fizz.fizzBuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fizz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                fizz.printNumber(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
