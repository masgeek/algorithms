package com.munywele;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzSingleThread {

    private List<String> fizzBuzzMeNoThread(int range) {
        List<String> stringList = new ArrayList<>();
        for (int x = 1; x <= range; x++) {
            if (x % 3 == 0 && x % 5 == 0) {
                stringList.add("FizzBuzz");
            } else if (x % 3 != 0 && x % 5 == 0) {
                stringList.add("Buzz");
            } else if (x % 3 == 0) {
                stringList.add("Fizz");
            } else {
                stringList.add(String.valueOf(x));
            }
        }

        return stringList;
    }

    public static void main(String[] args) {

        FizzBuzzSingleThread fizz = new FizzBuzzSingleThread();

        List<String> stringList = fizz.fizzBuzzMeNoThread(10);

        System.out.println(stringList.toString());
    }
}
