package com.avisow.exercise;

import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class Main {

    private static int B;
    private static int H;
    private static boolean flag = true;

//    static {
//        Scanner input = new Scanner(System.in);
//        B = input.nextInt();
//        H = input.nextInt();
//
//        if (B <= 0 || H <= 0) {
//            flag = false;
//            System.out.println("java.lang.Exception: Breadth and height must be positive");
//        }
//    }

    public static void main(String[] args) {
//        stdInStdOut();
//        stdInStdOut2();
//        outputFormatting();
//        loop();
//        intDataType();
        // scannerRead();

//        if (flag) {
//            int area = B*H;
//            System.out.println(area);
//        }

        Do_Not_Terminate.forbidExit();
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String s = Integer.toString(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            }
            else {
                System.out.println("Wrong answer");
            }
        }
        catch (Do_Not_Terminate.ExitTrappedExeption e) {
            System.out.println("Unsuccessful Termination!!");
        }


    }

    private static void scannerRead() {
        Scanner sc = new Scanner(System.in);
        int n = 1;

        while (sc.hasNext()) {
            System.out.println(n++ + " " + sc.nextLine());
        }
    }

    private static void intDataType() {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=Short.MIN_VALUE && x<=Short.MAX_VALUE)System.out.println("* short");
                if(x>=Integer.MIN_VALUE && x<=Integer.MAX_VALUE)System.out.println("* int");
                if(x>=Long.MIN_VALUE && x<=Long.MAX_VALUE)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }

    private static void loop() {
        /*In this problem you will test your knowledge of Java loops. Given three integers aa, bb, and nn, output the following series:

        a+20b,a+20b+21b,......,a+20b+21b+...+2n−1ba+20b,a+20b+21b,......,a+20b+21b+...+2n−1b

        Input Format

        The first line will contain the number of testcases t. Each of the next tt lines will have three integers, aa, bb, and nn.

                Constraints:

        0≤t≤5000≤t≤500
        0≤a,b≤500≤a,b≤50
        1≤n≤151≤n≤15

        Output Format

        Print the answer to each test case in separate lines.

        Sample Input

        2
        0 2 10
        5 3 5

        Sample Output

        2 6 14 30 62 126 254 510 1022 2046
        8 14 26 50 98

        Explanation

        In the first case:

        1st term=0+1*2=2
        2nd term=0+1*2+2*2=6
        3rd term=0+1*2+2*2+4*2=14

        and so on.*/

        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();

        int[] a = new int[t];
        int[] b = new int[t];
        int[] n = new int[t];

        for (int i = 0; i < t; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            n[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int e = a[i];
            for (int j = 0; j < n[i]; j++) {
                e += (int)Math.pow(2, j) * b[i];
                System.out.print(e + " ");
            }

            System.out.println();
        }
    }

    private static void outputFormatting() {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-10s%03d\n", s1, x);
        }
        System.out.println("================================");
    }

    private static void stdInStdOut2() {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        double y=sc.nextDouble();

        /*Note: If you use the nextLine() method immediately following the nextInt() method,
        recall that nextInt() reads integer tokens; because of this,
        the last newline character for that line of integer input is still queued in the input buffer
        and the next nextLine() will be reading the remainder of the integer line (which is empty).*/

        String s=sc.next();
        s=sc.nextLine();

        System.out.println("String: "+s);
        System.out.println("Double: "+y);
        System.out.println("Int: "+x);
    }

    private static void stdInStdOut() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{

            if(n>=1 && n<=5){
                ans = "Not Weird";
            }

            if(n>=6 && n<=20){
                ans = "Weird";
            }

            if(n>20){
                ans = "Not Weird";
            }
        }

        System.out.println(ans);
    }
}

class Do_Not_Terminate {
    public static class ExitTrappedExeption extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedExeption();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}