package com.munywele;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    static int majority = -1;

    static int majorityElementBT(int[] a, int size) {
        MyNode root = null;
        for (int x = 0; x < size; x++) {
            root = insertNode(root, a[x]);
        }
        //traverse the tree
        if (majority > (size / 2)) {
            inorder(root, size);
        }
        return -1;
    }

    //user inorder traversal
    private static void inorder(MyNode root, int size) {
        if (root != null) {
            inorder(root.left, size);

            if (root.count > (size / 2)) {
                System.out.println(root.key + "\n");
            }

            inorder(root.right, size);
        }
    }

    private static MyNode insertNode(MyNode root, int key) {
        if (root == null) {
            MyNode newNode = new MyNode();
            newNode.key = key;
            newNode.count = 1;
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }

        if (key < root.key) {
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
        } else {
            root.count++;
        }

        //determine the max
        if (root.count > majority) {
            majority = root.count;
        }
        return root;
    }

    static int majorityElement(int a[], int size) {
        int maxCount = 0;

        for (int x = 0; x < size; x++) {
            int count = 0;
            for (int y = 0; y < size; y++) {
                if (a[x] == a[y]) {
                    count++;
                }
            }
            //let us evaluate the number of occurences
            if (count > maxCount) {
                maxCount = count;
                majority = x;
            }

        }
        if (maxCount > size / 2) {
            return a[majority];
        }
        return -1;
    }

    long floorSqrt(long x) {
        // base case
        if (x == 0 || x == 1)
            return x;

        long start = 1, end = x, ans = 0;

        // binary search to find square root of a number
        while (start <= end) {
            long mid = (start + end) / 2;

            // if mid*mid == x, then mid is the required element
            if (mid * mid == x)
                return mid;

            // if mid*mid < x, then iterate for upper half
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            // else, iterate for lower half
            else
                end = mid - 1;

        }
        return ans;
    }

    public static boolean isValid(String s) {

        //create lookup has for valid ranges 0-255
        Set<String> ipRange = new HashSet<>();

        for (int mask = 0; mask < 256; mask++) {
            ipRange.add(String.valueOf(mask));
        }

        String[] splitMe = s.split("\\.");
        boolean isIpValid = false;
        //is split valid has less than four elements consider is invalid IP
        if (splitMe.length < 4) {
            return false;
        }

        int dotsCount = 0;
        for (int i = 0; i < splitMe.length; i++) {
            if (s.charAt(i) == '.') {
                dotsCount++;
            }
        }
        //check if dots match
        if (dotsCount != 3) {
            return false;
        }
        //check if ranges exist in allow mask
        for (int i = 0; i < splitMe.length; i++) {
            String mask = splitMe[i];
            if (!ipRange.contains(mask)) {
                return false;
            }
        }

        return isIpValid;
    }

    public static char[] urlIfy(char[] theString, int trueLength) {

        int spaceCount = 0;
        for (int i = 0; i < theString.length; i++) {
            if (theString[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = trueLength + spaceCount * 2;
        char[] newString = new char[newLength];
        int index = 0;

        for (int i = 0; i < theString.length; i++) {
            //check if the value is a space or not
            char c = theString[i];
            if (c == ' ') {
                newString[index] = '%';
                newString[index + 1] = '2';
                newString[index + 2] = '0';
                index = index + 3;
            } else {
                newString[index] = c;
                index++;
            }
        }

        return newString;
    }

    public static int convertStringToInt(String inputString) {

        int num = 0;
        int len = inputString.length();

        for (int x = 0; x < len; x++) {
            int asciValue = inputString.charAt(x) - 48;
            num = (num * 10) + asciValue;
        }
        return num;
    }

    public static String convertIntoString(int inputNumber) {

        int length = 0;
        String num = "";
        int rem = inputNumber;
        int val = inputNumber;
        while (rem > 0) {
            val = rem % 10;
            rem = rem / 10;
            char c = (char) (val + 48);
            num = c + num;
        }
        return num;
    }


    public static boolean isPalindrome(int inputNumber) {

        int length = 0;
        String num = String.valueOf(inputNumber);
        char[] strArr = num.toCharArray();
        char[] newArr = new char[strArr.length];
        int newIndex = 0;
        for(int x=strArr.length; x > 0; x-- ){
            newArr[newIndex] = strArr[x-1];
            newIndex++;
        }

        for (int y =0; y < strArr.length; y++){
            char cmpOld = strArr[y];
            char cmp = newArr[y];
            if(newArr[y]!=strArr[y]){
                return false;
            }
        }
        return true;
    }
}
