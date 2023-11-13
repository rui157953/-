package com.ryan.algorithm.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] twoSum = solution.twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.printf(Arrays.toString(twoSum));
    }


    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                final int i1 = target - nums[i];
                final Integer index = map.get(i1);
                if (index != null) {
                    return new int[]{index, i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}




