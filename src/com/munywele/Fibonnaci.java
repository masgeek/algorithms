package com.munywele;

public class Fibonnaci {


    public static void main(String[] args) {

        Fibonnaci sorting = new Fibonnaci();
        sorting.fibonacci(100);
    }

    private int fibonacci(int numberRange) {
        if (numberRange == 0) {
            return numberRange;
        }
        int n1 = 0;
        int n2 = 1;
        for (int x = 1; x <= numberRange; x++) {
            System.out.print(n1 + ", ");

            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return -1;
    }
}
