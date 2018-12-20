package com.codefights;

import java.util.*;

public class ContiguousSubarrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<>(m);
        List<Integer> numbers = new ArrayList(n);
        Map<Integer, Integer> count = new Hashtable<>();
        int maxUniqueIntegers = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            numbers.add(num);
//            deque.addLast(num);
        }

//        System.out.println("---List---");
//        printCollection(numbers);

        // get first m elements in deque
        for (int i = 0; i < m; i++) {
            int item = numbers.get(i);
//            int item = deque.getFirst();
            addToMapCount(item, count);
            deque.addLast(item);
        }

        if(maxUniqueIntegers < count.size()) {
            maxUniqueIntegers = count.size();
        }

        for (int i = m; i < n; i++) {
            int removedHead = deque.removeFirst();
            takeFromMapCount(removedHead, count);

            int item = numbers.get(i);
            addToMapCount(item, count);
            deque.addLast(item);

            if(maxUniqueIntegers < count.size()) {
                maxUniqueIntegers = count.size();
            }
        }

//        System.out.println("---Deque---");
//        printCollection(deque);
//
//        System.out.println("---Map---");
//        count.forEach((key, value) -> System.out.println("number: " + key + " value: " + value));
        System.out.println(maxUniqueIntegers);
    }

    static void addToMapCount(int number, Map<Integer, Integer> count) {
        Integer sum = count.get(number);
        if(sum!=null) {
            count.put(number, sum+1);
        } else {
            count.put(number, 1);
        }
    }

    static void takeFromMapCount(int number, Map<Integer, Integer> count) {
        Integer sum = count.get(number);
        if(sum!=null) {
            if (sum == 1) { //remove key if count is going to be 0
                count.remove(number);
            } else {
                count.put(number, sum-1);
            }
        }

    }

    static void printCollection(Collection collection){
        collection.forEach(e -> System.out.println("element: " + e));
    }
}
