package com.avisow.exercise;

import java.util.List;
import java.util.Scanner;

/**
 * Created by rwibawa on 3/3/2016.
 */
public class UtopianTree {
    public static void main(String[] args) {
        /*int[] input = { 1, 2 , 3, 4}; // { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // input array
        int k = 3; // subsequence length
        List<int[]> subsets = new ArrayList<>();
        GetPermutation(input, subsets);

        for (int[] subset : subsets) {
            for (int i : subset) {
                System.out.print(i + " ");
            }

            System.out.println();
        }*/

        //UtopianTree();
        int[] a = {2,3,10,2,4,8,1}; // {7,9,5,6,3,2};
        int result = maxDifference(a);
        System.out.println(result);


    }

    static int maxDifference(int[] a) {
        int result = -1;

        int N = a.length;
        if (N < 1 || N > 1000000) {
            return -1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (a[i] < -1000000 || a[i] > 1000000 ){
                return -1;
            }

            for (int j = i + 1; j < N; j++) {
                if (a[j] < -1000000 || a[j] > 1000000 ){
                    return -1;
                }

                int diff = a[j] - a[i];
                if (diff > result) {
                    result = diff;
                }
            }
        }

        return result;
    }

    private static void UtopianTree() {
        /*int T = 2;
        int[] N = {3,4};*/
        int h = 0;
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        int[] N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
        }

        for (int i = 0; i < T; i++) {
            for (int j = 0; j <= N[i]; j++) {
                if (j%2 == 0){
                    h++;
                } else {
                    h *= 2;
                }
            }

            System.out.println(h);
            h=0;
        }
    }

    private static void GetPermutation(int[] input, List<int[]> subsets) {
        for (int i = 1; i <= input.length; i++) {
            GetCombinations(i, input, subsets);
        }
    }


    private static void GetCombinations(int k, int[] input, List<int[]> subsets)
    {
        int[] s = new int[k]; // here we'll keep indices
        // pointing to elements in input array

        if (k <= input.length)
        {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++) {
            }

            subsets.add(getSubset(input, s));

            while (true)
            {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--) {
                }

                if (i < 0)
                {
                    break;
                }
                else
                {
                    s[i]++; // increment this item
                    for (++i; i < k; i++)
                    {
                        // fill up remaining items
                        s[i] = s[i - 1] + 1;
                    }

                    subsets.add(getSubset(input, s));
                }
            }
        }
    }

    // generate actual subsequence by index subsequence
    private static int[] getSubset(int[] input, int[] subset)
    {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
        {
            result[i] = input[subset[i]];
        }

        return result;
    }
}
