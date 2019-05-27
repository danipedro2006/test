package main.advanced.collections;

import main.fundamentals.bank.Employer;
import main.fundamentals.bank.Person;

import java.util.*;

public class MapTest {


    public static void main(String[] args) {

        // immutable numberMap
        Map<Integer, String> numberMap = Map.of(
                1, "one",
                2, "two",
                3, "three"
        );
        System.out.println(numberMap);
        // Prints:  {3=three, 2=two, 1=one}

        // throws java.lang.UnsupportedOperationException
        // numberMap.put(4, "four");


        Map<Integer, Person> personMap = new TreeMap<>();
        System.out.println("Map size: " + personMap.size());
        System.out.println("Map type: " + personMap.getClass().getName());

        // add elements
        personMap.put(123, new Person("Mary", Employer.Azets, "Timisoara"));
        personMap.put(589, new Person("Yvone", Employer.IBM, "Timisoara"));
        personMap.put(7, new Person("Robert", Employer.Visma, "Timisoara"));
        // same value for different keys
        personMap.put(1111, new Person("Robert", Employer.Visma, "Timisoara"));

        // change value for existing key
        personMap.put(7, new Person("NEW", Employer.Consignor, "Timisoara"));

        System.out.println("Map size: " + personMap.size());
        //System.out.println("Map: " + personMap);


        // Iterations
        System.out.println("\n\nIterations:");
        //1. using keySet()
        Set<Integer> keys = personMap.keySet();
        System.out.println("Keys: " + keys);

        for(int key : keys){

            System.out.println(key + " = "
                    + personMap.get(key)
                        .toString()
                        .replaceAll("\n", " "));
        }

        /*personMap.keySet().forEach( key ->
                System.out.println(key + " = "
                        + personMap.get(key)
                        .toString()
                        .replaceAll("\n", " ")));*/


        //2. using values
        System.out.println("\nValues: ");
        Collection<Person> values = personMap.values();
        //System.out.println("\nValues: " + values);

        for(Person person : values){

            System.out.println(person
                    .toString()
                    .replaceAll("\n", " "));
        }

        //3. using entrySet
        System.out.println("\nentrySet: ");
        Set<Map.Entry<Integer, Person>> entrySet = personMap.entrySet();
        for (Map.Entry<Integer, Person> entry : entrySet){
            System.out.println(
                    entry.getKey() + " : "
                    + entry.getValue().toString().replaceAll("\n", " "));

        }

/*        personMap.entrySet().forEach(entry ->
                System.out.println(
                        entry.getKey() + " : "
                                + entry.getValue().toString()
                                    .replaceAll("\n", " ")));*/

        Map<String, String> namesMap = new HashMap<>();
        namesMap.put("id1", "Dan");
        namesMap.put("id2", "Dorina");
        System.out.println(namesMap);

        System.out.println("\nnamesMap hash: " + namesMap.hashCode());
    }



}
