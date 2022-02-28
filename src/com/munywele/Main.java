package com.munywele;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] A = {-1,-6,1,2,3,4,5,6,7,8,1000};
        int smallest = smallestInt(A);

        System.out.println(smallest);

    }

    private static int smallestInt(int[] A){
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            System.out.println("The value number is "+i);
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }
    public static void mainA(String[] args) {
        Searching search = new Searching();
        int[] arrays = {1, 2, 3, 4, 85, 7, 8, 79, 78, 80, 82, 90, 85, 99, 81};
        int itemToFind = 85;
        int lastItemIndex = arrays.length - 1;
        int firstItemIndex = 0;
        Arrays.sort(arrays);//first let us sort the arrays
        int atIndex = search.binarySearchRecursion(arrays, firstItemIndex, lastItemIndex, itemToFind);
        if (atIndex < 0) {
            System.out.println("Element " + itemToFind + " not found in provided array");
        } else {
            System.out.println("The element " + itemToFind + " is at index " + atIndex);
        }
    }

    public static void main2(String[] args) {
        Graph gr = new Graph(5);
        gr.addEdge(1, 0);
        gr.addEdge(0, 2);
        gr.addEdge(2, 1);
        gr.addEdge(0, 3);
        gr.addEdge(3, 4);

        if (gr.isCyclic()) {
            System.out.println("Graph is cylcic");
        } else {
            System.out.println("Graph is not cyclic");
        }

//        int number = Solution.convertStringToInt("452");
        String number = Solution.convertIntoString(452);

        System.out.println(number);

        int value = 1000170001;
        boolean palindrome = Solution.isPalindrome(value);
        if (palindrome) {
            System.out.printf("%d is a palindrome \n", value);
        } else {
            System.out.printf("%d is not a palindrome \n", value);
        }
    }

    public static void mainOld(String[] args) {

        int[] A = {1, 3, 3, 3, 2};
        int element = Solution.majorityElementBT(A, A.length);

//        String  k = "222.111.111.111";
        String k = "0.0.0.0";

//        boolean kl = Solution.isValid(k);

        String withSpaces = "Mr John Smith    ";
        char[] withSpacesArr = withSpaces.toCharArray();


        char[] isString = Solution.urlIfy(withSpacesArr, withSpaces.length());
        for (int i = 0; i < isString.length; i++) {
            System.out.print(isString[i]);
        }

        int number = Solution.convertStringToInt("452");
        System.out.println(number);
    }
}
