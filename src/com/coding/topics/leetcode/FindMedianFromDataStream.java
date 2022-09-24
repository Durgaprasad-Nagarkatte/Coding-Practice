package com.coding.topics.leetcode;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        // For maintaining the left half
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // For maintaining the right half
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    private void balanceHeaps() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();


        if(minHeapSize > maxHeapSize){
            int elem = minHeap.poll();
            maxHeap.add(elem);
            return;
        }

        if(maxHeapSize > minHeapSize + 1) {
            int elem = maxHeap.poll();
            minHeap.add(elem);
        }
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }

        if(minHeap.isEmpty()){
            int elem = maxHeap.peek();
            if(num < elem){
                maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(elem);
            }else{
                minHeap.add(num);
            }
            return;
        }

        if(maxHeap.peek() < num) {
            minHeap.add(num);
        }else {
            maxHeap.add(num);
        }

        balanceHeaps();
    }

    public double findMedian() {
        double median = 0;
        int totalSize = maxHeap.size() + minHeap.size();

        if(totalSize > 0) {
            median = totalSize%2 == 0 ? Double.valueOf(maxHeap.peek() + minHeap.peek())/2 : maxHeap.peek();
        }

        return median;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

        medianFinder.addNum(-1);    // arr = [1]
        medianFinder.addNum(-2);    // arr = [1, 2]
        //System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(-3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }


}
