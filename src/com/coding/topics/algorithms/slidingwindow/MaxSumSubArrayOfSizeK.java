package com.coding.topics.algorithms.slidingwindow;

/*
  Given an array of positive numbers and a positive number ‘k,’
  find the maximum sum of any contiguous subarray of size ‘k’.

  i = 3
  i-k = 0

  i = 4
  i-k = 1
  Input: [2, 1, 5, 1, 3, 2], k=3
  Output: 9
  Explanation: Subarray with maximum sum is [5, 1, 3].
  l - k + 1 = 6 - 3 + 1

  Input: [2, 3, 4, 1, 5], k=2
  Output: 7
  l - k + 1 = 5 - 2 + 1
  Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int sum = 0;
    int max = Integer.MIN_VALUE;

    // Calculating the sum of first k elements
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    for (int i = k; i < arr.length; i++) {
      sum += arr[i];
      sum -= arr[i-k];
      max = Math.max(max, sum);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] {2, 1, 5, 1, 3, 2};
    System.out.println("Max sum of subarray : " + findMaxSumSubArray(3, arr1));

    int[] arr2 = new int[] {2, 3, 4, 1, 5};
    System.out.println("Max sum of subarray : " + findMaxSumSubArray(2, arr2));

    int[] arr3 = new int[] {2, 3, 4, 1, 5};
    System.out.println("Max sum of subarray : " + findMaxSumSubArray(1, arr2));
  }

}
