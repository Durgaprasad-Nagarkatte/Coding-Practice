package com.coding.topics.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int[] maxElements = new int[nums.length - k + 1];
        int j = 0;

        for(int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(!maxHeap.isEmpty()) {
                maxElements[j++] = maxHeap.peek();
                maxHeap.remove(nums[i-k]);
                maxHeap.add(nums[i]);
            }
        }

        maxElements[j] = maxHeap.peek();
        return maxElements;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
        result = slidingWindowMaximum.maxSlidingWindow(new int[]{1}, 1);
        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
        result = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 1, 1}, 2);
        Arrays.stream(result).forEach(System.out::print);
    }

}
