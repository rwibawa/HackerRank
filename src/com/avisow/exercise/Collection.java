package com.avisow.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rwibawa on 3/3/2016.
 */
public class Collection {
    public static void main(String[] args) {
        // negativeSubArrays();
        cellPhoneGame();
    }

    private static void cellPhoneGame() {
        /*
        You are playing a game on your cellphone. You are given an array of length nn, indexed from 00 to n−1n−1. Each element of the array is either 00 or 11. You can only move to an index which contains 00. At first you are at the 0th0th position. In each move you can do one of the following things:

Walk one step forward or backward.
Make a jump of exactly length mm forward.
That means you can move from position xx to x+1x+1, x−1x−1 or x+mx+m in one move. The new position must contain 0. Also you can move to any position greater than n-1.

You can't move backward from position 00. If you move to any position greater than n−1n−1, you win the game.

Given the array and the length of the jump, you need to determine if it's possible to win the game or not.

Input Format

In the first line there will be an integer TT denoting the number of test cases. Each test case will consist of two lines. The first line will contain two integers, nn and mm. On the second line there will be nn space-separated integers, each of which is either 00 or 11.

Constraints:

1<=T<=50001<=T<=5000
2≤n≤1002≤n≤100
0≤m≤1000≤m≤100
The first integer of the array is always 00.

Output Format

For each case output "YES" if it's possible to win the game, output "NO" otherwise.

Sample Input

4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
Explanation

In the first case you can just walk to reach the end of the array.
In the second case, you can walk to index 1 or 2 and jump from there. In the third case, jump length is too low, you can't reach the end of the array. In the fourth case, jump length is 1, so it doesn't matter if you jump or walk, you can't reach the end.
        */

        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            String parameter = in.nextLine();
            String[] element = parameter.split(" ");
            int n = Integer.parseInt(element[0]);
            int m = Integer.parseInt(element[1]);

            int[] array = new int[n];
            parameter = in.nextLine();
            int h = 0;
            for (String e : parameter.split(" ")) {
                array[h++] = Integer.parseInt(e);
            }

            if (walk(n, m, array)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean walk(int n, int m, int[] array) {
        int pointer = 0;
        Set<Integer> previousPosition = new HashSet<>();
        previousPosition.add(pointer);

        while (true) {
            int nextPointer = pointer + m;
            if (nextPointer > n - 1) {
                return true;
            }

            if (array[nextPointer] == 0 && !previousPosition.contains(nextPointer)) {
                pointer = nextPointer;
                previousPosition.add(pointer);
                continue;
            }

            nextPointer = pointer + 1;
            if (array[nextPointer] == 0 && !previousPosition.contains(nextPointer)) {
                pointer = nextPointer;
                previousPosition.add(pointer);
                continue;
            }

            nextPointer = pointer - 1;
            if (nextPointer < 0) {
                return false;
            }

            if (array[nextPointer] == 0 && !previousPosition.contains(nextPointer)) {
                pointer = nextPointer;
                previousPosition.add(pointer);
                continue;
            }

            return false;
        }

    }

    private static void negativeSubArrays() {
        // int[] n = {1, -2, 4, -5, 1};
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[] n = new int[t];
        String array = in.nextLine();
        int h = 0;
        for (String element : array.split(" ")) {
            n[h++] = Integer.parseInt(element);
        }

        h = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = i; j < n.length; j++) {
                int sum = 0;
                if (i == j) {
                    sum = n[i];
                } else {
                    for (int k = i; k <= j; k++) {
                        sum += n[k];
                    }
                }

                if (sum < 0) {
                    // System.out.println("[" + i + ":" + j + "]");
                    h++;
                }
            }
        }

        System.out.println(h);
    }
}
