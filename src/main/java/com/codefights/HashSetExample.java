package com.codefights;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
////        System.out.println("Give me number of strings (n) strings: ");
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        Set<String> pairs = new HashSet<>(n);
//        for(int i=0; i<n; i++) {
////            System.out.println("Give me pair " + i + ":");
//            String pair = scanner.nextLine();
//            pairs.add(pair);
//            System.out.println(pairs.size());
//        }
//    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        Set<String> pairs = new HashSet<>(t);

        for (int i = 0; i < t; i++) {
            pairs.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(pairs.size());
        }
    }
}
