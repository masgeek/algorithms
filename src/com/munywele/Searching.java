package com.munywele;

public class Searching {

    public int firstMissingPositive(int[] nums) {
        return 0;
    }

    public int binarySearchClassic(int[] arrays, int left, int right, int itemToFind) {
        int itemIndex = -1;

        int mid = left + (right - left) / 2; //find the mid index
        while (left <= right) {
            int midValue = arrays[mid];
            if (midValue < itemToFind) {
                //increment the mid index since it is not found in the lower part
                left = mid + 1;
            } else if (midValue == itemToFind) {
                itemIndex = mid; //this is the index position
                break; //exit the loop
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return itemIndex;
    }

    public int binarySearchRecursion(int[] arrays, int left, int right, int itemToFind) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (arrays[mid] == itemToFind) {
                return mid;
            } else if (itemToFind < arrays[mid]) {
                return binarySearchRecursion(arrays, left, mid - 1, itemToFind);//discard the right portion + mid index
            } else {
                return binarySearchRecursion(arrays, mid + 1, right, itemToFind);//discard the left portion + mid index
            }
        }
        return -1;
    }

    public int linearSearch(int[] arrays, int itemToFind) {
        int itemIndex = -1;
        for (int x = 0; x < arrays.length; x++) {
            if (arrays[x] == itemToFind) {
                itemIndex = x;
            }
        }
        return itemIndex;
    }
}
