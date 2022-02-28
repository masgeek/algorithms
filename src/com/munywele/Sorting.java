package com.munywele;

public class Sorting {

    /**
     * Worst case time complexity is O(n^2)
     */
    public void quickSort(int[] array, int beg, int end) {
        int pivot;
        if (beg < end) {
            //let us partition the array so we compare the left first then the right
            pivot = partition(array, beg, end);
            quickSort(array, beg, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }
    private int partition(int[] array, int beg, int end) {
        int pivot = array[end]; //get the item to pivot from
        int swapIndex = beg - 1;
        for (int x = beg; x < end; x++) {
            //check if current element is less than the pivot value
            int currEl = array[x];
            if (currEl < pivot) {
                //increment the beginning index by 1 to go to the next one
                swapIndex++;
                int temp = array[x];
                //swap the array positions
                array[x] = array[swapIndex];
                array[swapIndex] = temp;//move the temp value to the new position
            }
        }
        //swap array here too with the end index
        int temp = array[swapIndex + 1];
        //swap the array positions
        array[swapIndex + 1] = array[end];
        array[end] = temp;//move the temp value to the new position
        return swapIndex;
    }

    /**
     * Worst case time complexity is O(n log(n))
     */
    public void mergeSort(int[] array, int beg, int end) {
        if (beg < 2) {
            return; //no logical sense to sort a one item array
        }
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(array, beg, mid); //first half
            mergeSort(array, mid + 1, end); //second half

            //merge the sorted halves
            merge(array, beg, mid, end);
        }
    }

    private void merge(int[] array, int beg, int mid, int end) {
//find size of the arrays to merged
        int arr1Size = mid - beg + 1;
        int arr2Size = end - mid;

        //create two temporary array to hold the values
        int[] arr1 = new int[arr1Size];
        int[] arr2 = new int[arr2Size];

        //copy data to the temporary arrays
        for (int x = 0; x < arr1Size; x++) {
            arr1[x] = array[beg + x];
        }
        for (int j = 0; j < arr2Size; j++) {
            arr2[j] = array[mid + 1 + j];
        }

        //merge the two arrays now
        int arr1Index = 0, arr2Index = 0;
        int initialIndex = beg;
        while (arr1Index < arr1Size && arr2Index < arr2Size) {
            if (arr1[arr1Index] <= arr2[arr2Index]) {
                array[initialIndex] = arr1[arr1Index];
                arr1Index++;
            } else {
                array[initialIndex] = arr2[arr2Index];
                arr2Index++;
            }
            initialIndex++;
        }

        /* Copy remaining elements of arr1[] if any */
        while (arr1Index < arr1Size) {
            array[initialIndex] = arr1[arr1Index];
            arr1Index++;
            initialIndex++;
        }

        /* Copy remaining elements of arr2[] if any */
        while (arr2Index < arr2Size) {
            array[initialIndex] = arr2[arr2Index];
            arr2Index++;
            initialIndex++;
        }

    }


    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] sortArray = {10, 30, 80, 90, 40, 50, 70};


        System.out.println("\n before Merge sort array: ");
        sorting.printArray(sortArray, sortArray.length);

        sorting.quickSort(sortArray, 0, sortArray.length - 1);
        sorting.mergeSort(sortArray, 0, sortArray.length - 1);

        System.out.println("Sorted array: ");
        sorting.printArray(sortArray, sortArray.length);
        System.out.println("\nMerge sort array: ");
        sorting.printArray(sortArray, sortArray.length);
    }

    private void printArray(int[] sortArray, int length) {
        //print the array
        for (int x = 0; x < length; x++) {
            System.out.print(sortArray[x] + " ");
        }
    }
}
