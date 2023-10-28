package com.Maxim.AlgorithmicTasks;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SecondTask {

    static int[] Array= {4,5,6,6,8};
    static int[] Array2= {4,5,6,7,8};

    public static void main(String[] args) {
        System.out.println(task2(Array));

    }


    public static boolean task2(int [] array) {

        Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
        return set.size() != array.length;

    }
}
