package main.advanced.collections;

import java.util.HashMap;
import java.util.Map;

public class DeclarativeMapOperations {

    public static void main(String[] args) {

        Map<Integer, String> imap = Map.of(
                1, "a",
                2, "b",
                3, "c");

        Map<Integer, String> map = new HashMap<>();
        map.putAll(imap);
        System.out.println("Initial map: " + map);

        // 1
        System.out.println("not present, computeIfAbsent:");
        map.computeIfAbsent(0, k -> "d");
        //map.putIfAbsent(0, "d");
        System.out.println(map);

        // 2
        System.out.println("present, computeIfAbsent:");
        map.computeIfAbsent(0, k -> "d");
        //map.putIfAbsent(0, "d");
        System.out.println(map);

        // 3
        System.out.println("present, computeIfPresent:");
        map.computeIfPresent(0, (k, v) -> k + v + "d");
        System.out.println(map);

    }
}
