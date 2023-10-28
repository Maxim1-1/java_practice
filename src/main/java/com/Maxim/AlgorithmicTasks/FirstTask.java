package com.Maxim.AlgorithmicTasks;

import java.util.*;

public class FirstTask {

    static int[] array = {2, 7, 11, 15};

    public static void main(String[] args) {

        System.out.print(twoSum1(array, 9));
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}