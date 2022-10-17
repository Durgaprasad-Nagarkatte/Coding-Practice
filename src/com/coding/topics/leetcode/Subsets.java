package com.coding.topics.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {

    public void generateSubsets(List<List<Integer>> subsets, Stack<Integer> s, int[] nums, int start){

        // Base condition check
        if(start == nums.length) {
            return;
        }


        for(int i = start; i < nums.length; i++) {
            s.add(nums[i]);

            List<Integer> copy = new ArrayList<>(s);
            subsets.add(copy);

            generateSubsets(subsets, s, nums, i+1);

            s.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        subsets.add(new ArrayList<>(s));

        generateSubsets(subsets, s, nums, 0);
        return subsets;
    }

    public static void main(String[] args){
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1}));
    }

}
