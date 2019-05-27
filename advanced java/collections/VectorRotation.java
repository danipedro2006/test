package main.advanced.collections;

import java.util.List;
import java.util.Vector;

public class VectorRotation {


    public static void main(String[] args) {

        Vector<Integer> v = new Vector<>();

        v.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));


        System.out.println(rotateRight(v, 145));

        System.out.println(rotateRight2(v, 145));
    }


    public static Vector<Integer> rotateRight(Vector<Integer> v, int rotationsCount){

        Vector<Integer> finalVector = new Vector<>();
        finalVector.addAll(v);

        // rotate rotationsCount times
        for(int i=0; i < rotationsCount % v.size(); i++){
            finalVector = rotateRightOnce(finalVector);
        }

        return finalVector;
    }


    public static Vector<Integer> rotateRight2(Vector<Integer> v, int rotationsCount){

        //

        Vector<Integer> finalVector = new Vector<>();

        int rotationStartIndex = v.size() - rotationsCount % v.size();

        finalVector.addAll(v.subList(rotationStartIndex, v.size()));

        finalVector.addAll(v.subList(0, rotationStartIndex));

        return finalVector;
    }



    public static Vector<Integer> rotateRightOnce(Vector<Integer> v){

        Vector<Integer> finalVector = new Vector<>();

        // copy elements from index 1 .. size-1
        finalVector.addAll(v.subList(0, v.size()-1));

        // put the last element on index 0
        finalVector.add(0, v.get(v.size()-1));

        return finalVector;
    }

}
