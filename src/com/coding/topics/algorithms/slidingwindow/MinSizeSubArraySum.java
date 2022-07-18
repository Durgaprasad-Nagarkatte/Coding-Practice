package com.coding.topics.algorithms.slidingwindow;

/*
  Given an array of positive integers and a number ‘S,’
  find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
  Return 0 if no such subarray exists.

  Input: [2, 1, 5, 2, 3, 2], S=7
  Output: 2
  Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].

  Input: [2, 1, 5, 2, 8], S=7
  Output: 1
  Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [8].

  Input: [3, 4, 1, 1, 6], S=8
  Output: 3
  Explanation: Smallest sub arrays with a sum greater than or equal to ‘8’ are [3, 4, 1] or [1, 1, 6].
 */
public class MinSizeSubArraySum {
  public static boolean isSubArrayGreaterThanS(int S, int[] arr, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    for(int i = k; i < arr.length; i++) {
      if (sum >= S) {
        return true;
      }
      sum -= arr[i-k];
      sum += arr[i];
    }

    return sum >= S;
  }

  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    for(int i = 1; i <= arr.length; i++){
      boolean isGreaterThanS = isSubArrayGreaterThanS(S, arr, i);
      if(isGreaterThanS) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] {2, 1, 5, 2, 3, 2};
    System.out.println("The minimum size of the sub-array is : " + findMinSubArray(7, arr1));

    int[] arr2 = new int[] {2, 1, 5, 2, 8};
    System.out.println("The minimum size of the sub-array is : " + findMinSubArray(7, arr2));

    int[] arr3 = new int[] {3, 4, 1, 1, 6};
    System.out.println("The minimum size of the sub-array is : " + findMinSubArray(8, arr3));
  }
}
