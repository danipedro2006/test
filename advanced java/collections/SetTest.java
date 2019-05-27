package main.advanced.collections;

import java.util.*;

// Set - unindexed list, with unique elements
public class SetTest {

    public static void main(String[] args) {

        Set<String> wordSet = new TreeSet<>();
        System.out.println("wordset is empty: " + wordSet.isEmpty());

        boolean isAdded;
        isAdded = wordSet.add("vehicle");
        System.out.println("vehicle isAdded: " + isAdded);

        isAdded = wordSet.add("car");
        System.out.println("car isAdded: " + isAdded);

        isAdded = wordSet.add("plane");
        System.out.println("plane isAdded: " + isAdded);

        System.out.println("plane isAdded: " + wordSet.add("plane"));


        System.out.println("wordSet (as set): " + wordSet);
        Object[] wordArray = wordSet.toArray();
        System.out.println("wordSet (as array): " + Arrays.toString(wordArray));

        // subset
        Set<String> subSet = new HashSet<>();
        subSet.addAll(wordSet);
        subSet.remove("plane");
        System.out.println("subSet: " + subSet);


        System.out.println("wordsSet contains subSet: " +  wordSet.containsAll(subSet));

        subSet.clear();
        System.out.println("subSet after clear(): " + subSet);
        System.out.println("subSet isEmpty: " + subSet.isEmpty());

        for( String word : wordSet){
            System.out.println(word);
        }

        // Collection, List, ArrayList
        List<String> wordList = Arrays.asList("plane", "plane", "vehicle", "train", "bus");
        System.out.println("wordList: " + wordList);

        System.out.println("\nwordSet: " + wordSet);
        wordSet.removeAll(wordList);
        System.out.println("wordSet after removing wordList: " + wordSet);




    }

}
