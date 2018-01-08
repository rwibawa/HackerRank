package com.avisow.exercise;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ryan on 8/26/16.
 */

// Sort an array of 'A's, 'B's and 'C's
// { "A", "C", "B", "B" } -> { "A", "B", "B", "C" }

public class Autodesk {
    public static void main(String[] args) {
        String[] array = { "A", "C", "B", "B", "C", "C", "C", "C" }; //{ "A", "C", "B", "B" };
        // Arrays.sort(array);
        int numberOfA = 0;
        int numberOfB = 0;
        int numberOfC = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("A")) {
                numberOfA++;
            }

            if (array[i].equals("B")) {
                numberOfB++;
            }

            if (array[i].equals("C")) {
                numberOfC++;
            }
        }

        for (int i = 0; i < numberOfA; i++) {
            System.out.println("A");
        }

        for (int i = 0; i < numberOfB; i++) {
            System.out.println("B");
        }

        for (int i = 0; i < numberOfC; i++) {
            System.out.println("C");
        }

//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }

    public class Node {

    }
}
