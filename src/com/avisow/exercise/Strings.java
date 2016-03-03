package com.avisow.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rwibawa on 2/25/2016.
 */
public class Strings {
    public static void main(String[] args) {
        // CapitalizeFirstLetter();
        // SortSubstrings();

        /*String A = "java";
        if (Palindrome(A)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }*/

        /*Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();*/
        /*String A="Hello";
        String B="Yello";
        boolean ret=isAnagram(A,B);
        if(ret)System.out.println("Anagrams");
        else System.out.println("Not Anagrams");*/

        // Regex
        /*Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String IP = in.next();
            System.out.println(IP.matches(new myRegex().pattern));
        }*/

        /*String[] IPs = {"000.12.12.034",
                "121.234.12.12",
                "23.45.12.56",
                "00.12.123.123123.123",
                "122.23",
                "Hello.IP"};
        for (String IP : IPs) {
            System.out.println(IP.matches(new myRegex().pattern));
        }*/

        // Duplicated words
        String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*"; // "\\b(\\w+)\\b\\s+\\b\\1\\b";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE+Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String input = in.nextLine();
            Matcher m = r.matcher(input);
            boolean findMatch = true;
            while(m.find( )){
                input = input.replaceAll(m.group(), m.group(1));
                findMatch = false;
            }
            System.out.println(input);
            testCases--;
        }
    }

    private static void Tokenize() {
        // String to be scanned to find the pattern.
        String s = "He is a very very good boy, isn't he?";
        String pattern = "[A-Za-z]+"; //"(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(s);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            String substring = s.substring(m.start(), m.end());
            result.add(substring);
            //System.out.println(substring);
        }

        System.out.println(result.size());
        result.forEach(System.out::println);
        /*if (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
            *//*System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );*//*
        } else {
            System.out.println("NO MATCH");
        }*/
    }

    static boolean isAnagram(String A, String B) {
        //Complete the function
        if (A.length() != B.length()) {
            return false;
        }

        Map<Character, Integer> dictionary = new HashMap<>();
        for (char c : A.toCharArray()) {
            c = Character.toLowerCase(c);
            if (dictionary.containsKey(c)) {
                int count = dictionary.get(c);
                dictionary.put(c, ++count);
            } else {
                dictionary.put(c, 1);
            }
        }

        for (char c : B.toCharArray()) {
            c = Character.toLowerCase(c);
            if (dictionary.containsKey(c)) {
                int count = dictionary.get(c);
                if (--count == 0) {
                    dictionary.remove(c);
                    continue;
                }

                dictionary.put(c, count);
            } else {
                return false;
            }
        }

        return dictionary.isEmpty();
    }

    private static boolean Palindrome(String A) {
        int reverseIndex = A.length() - 1;

        for (int i = 0; i < A.length(); i++) {
            if (Character.toLowerCase(A.charAt(i)) != Character.toLowerCase(A.charAt(reverseIndex--))) {
                return false;
            }
        }

        return true;
    }

    private static void SortSubstrings() {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();

        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length() - k + 1; i++ ) {
            String substring = str.substring(i, i + k);
            substrings.add(substring);
            // System.out.println(substring);
        }

        Collections.sort(substrings);
        System.out.println(substrings.get(0));
        System.out.println(substrings.get(substrings.size() - 1));
    }

    private static void CapitalizeFirstLetter() {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());
        if (A.compareToIgnoreCase(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1) + " " +
                B.substring(0,1).toUpperCase() + B.substring(1));
    }
}

class myRegex {

    public String pattern =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
