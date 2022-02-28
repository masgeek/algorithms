package com.munywele.threads;

public class RunnableExample implements Runnable {

    public int count = 0;

    @Override
    public void run() {

    }

    /**
     * @return returns a string value
     */
    public synchronized String getNames() {
        return "samerm";
    }
}
