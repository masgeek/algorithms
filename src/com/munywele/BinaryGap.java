package com.munywele;

import java.util.*;

public class BinaryGap {

    public static void main(String[] args) {
        int myValue = 1376796946;

//        char[] AB = Integer.toBinaryString(myValue).toCharArray();

//        Stack<Integer> data = decimalToBinary(myValue);
//        int binaryStr = data.indexOf(0);

        int longestGap = longestGap(myValue);
        System.out.println("Longest binary gap is "+longestGap);
    }

    private static int longestGap(int N) {
        int longestBinaryGap = 0;
        String originalBinary = Integer.toBinaryString(N);
        // write your code in Java SE 8
        if(N <=0)
        {
            return 0;
        }

        String binaryString = "";
        while(N>0){
            int binValue = N%2;
            if(binValue==0){
                binaryString = "0"+binaryString;
            }else{
                binaryString = "1"+binaryString;
            }
            N = N/2;
        }

         System.out.println("My stack value is:"+binaryString);
         System.out.println("Binary value is  :"+originalBinary);
        //next evaluate the occurences of 0
        int tempBinaryGap =0;
        char[] theValues = binaryString.toCharArray();

        for(int x=0; x< theValues.length;x++){
            char binaryValue = theValues[x];
            if(binaryValue=='0'){
                tempBinaryGap++;
            }else{
                if(tempBinaryGap>longestBinaryGap){
                    longestBinaryGap = tempBinaryGap;
                }
                tempBinaryGap=0;
            }
        }
        return longestBinaryGap;
    }
    private static int longestGap(Stack<Integer> ab) {
        //loop through this, binary and check numbers of subsequent zeroes
        int longestBinaryGap = 0;
        int tempGap = 0;
        int charLen = ab.size();
        for(int x=0; x<charLen;x++){
            int bitValue = ab.get(x);
            if(bitValue==0){
                //increment the gap
                tempGap++;
            }else{
                if(tempGap>longestBinaryGap){
                    longestBinaryGap = tempGap;
                }
                tempGap = 0;
            }
        }
        return longestBinaryGap;
    }

    static Stack<Integer> decimalToBinary(int num) {
        Stack<Integer> binary = new Stack<>();
        while (num > 0) {
            int myBinary = num % 2;
            num = num / 2;
            binary.push(myBinary);
        }
        return binary;
    }

}
