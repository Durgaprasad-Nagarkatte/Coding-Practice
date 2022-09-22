package com.coding.topics.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> nonOverlappingIntervals = new ArrayList<>();

        // Sorting the array by the first element
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        int min = intervals[0][0];
        int max = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= max) {
                max = Math.max(max, intervals[i][1]);
            } else {
                nonOverlappingIntervals.add(List.of(min, max));
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }

        nonOverlappingIntervals.add(List.of(min, max));

        int[][] nonOverlappingArrayIntervals = new int[nonOverlappingIntervals.size()][2];

        for(int i = 0; i < nonOverlappingIntervals.size(); i++) {
            nonOverlappingArrayIntervals[i][0] = nonOverlappingIntervals.get(i).get(0);
            nonOverlappingArrayIntervals[i][1] = nonOverlappingIntervals.get(i).get(1);
        }

        return nonOverlappingArrayIntervals;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] nonOverlappingIntervals = mergeIntervals.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(nonOverlappingIntervals));
        nonOverlappingIntervals = mergeIntervals.merge(new int[][] {{1,4},{4,5}});
        System.out.println(Arrays.deepToString(nonOverlappingIntervals));
        nonOverlappingIntervals = mergeIntervals.merge(new int[][] {{1,4},{0,4}});
        System.out.println(Arrays.deepToString(nonOverlappingIntervals));
    }
}
