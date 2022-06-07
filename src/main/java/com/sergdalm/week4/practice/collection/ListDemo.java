package com.sergdalm.week4.practice.collection;

import java.util.*;
import java.util.function.Function;

public class ListDemo {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add(0, "hi");
        //System.out.println(strings);


//        List<String>[] arrayOfStrings = new List<String>[5];
//        List<Object>[] array = arrayOfStrings;

//        Object[] x = new String[5];
//        x[0] = new Integer(5);
//        System.out.println(x[0]);

        method(5, "g");


//        Map<Map, Map> mapOfMaps = new HashMap<>();
//        mapOfMaps.put(mapOfMaps, mapOfMaps);
//        System.out.println(mapOfMaps);
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "a");
        map.put(11, "a");
        map.put(3, "c");
        map.put(2, "b");
        map.put(4, "b");
        map.put(44, "b");
        map.put(9, "b");
        map.put(0, "b");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);


    }

    public static <T> void method(T a, T b) {

    }
}
