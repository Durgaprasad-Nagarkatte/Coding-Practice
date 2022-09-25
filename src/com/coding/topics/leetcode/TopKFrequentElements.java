package com.coding.topics.leetcode;

import java.util.*;

public class TopKFrequentElements {
    public static class Element {
        int key;
        int count;

        public Element(int key, int count) {
            this.key = key;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "key=" + key +
                    ", count=" + count +
                    '}';
        }
    }


    public int[] topKFrequent(int[] nums, int k) {

        int[] topKElements = new int[k];
        int j = 0;
        Map<Integer, Integer> frequencyCounter = new HashMap<>();

        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparing(Element::getCount));

        // Creating a frequency counter
        for (int num : nums) {
            frequencyCounter.put(num, frequencyCounter.getOrDefault(num, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> keyCounter : frequencyCounter.entrySet()) {
            // Inserting first k elements into the heap
            if(j < k){
                minHeap.add(new Element(keyCounter.getKey(), keyCounter.getValue()));
                j++;
            }else {
                System.out.println(minHeap);
                int min = minHeap.peek().count;
                if(min < keyCounter.getValue()) {
                    minHeap.poll();
                    minHeap.add(new Element(keyCounter.getKey(), keyCounter.getValue()));
                }
            }
        }

        // Add the top K elements into the list
        for(int i = 0; i < k; i++){
            topKElements[i] = minHeap.poll().key;
        }

        System.out.println(Arrays.toString(topKElements));

        return topKElements;
    }

    public static void main(String[] args){
        TopKFrequentElements frequentElements = new TopKFrequentElements();
        frequentElements.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}
