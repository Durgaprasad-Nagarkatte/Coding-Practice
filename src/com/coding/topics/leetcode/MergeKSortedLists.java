package com.coding.topics.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static class Element {
        int val;
        ListNode next;

        public Element(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode headNode = null;
        ListNode currNode = null;

        // Heap to get the min element from the lists
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparing(Element::getVal));

        // Add all the first elements from the lists
        for(int i = 0; i < lists.length; i++){
            ListNode tempHeadNode = lists[i];

            if(tempHeadNode != null){
                minHeap.add(new Element(tempHeadNode.val, tempHeadNode.next));
            }
        }

        while(!minHeap.isEmpty()) {
            Element currElement = minHeap.poll();

            // Adding elements to a consolidated list
            if(headNode == null){
                headNode = new ListNode(currElement.val);
                currNode = headNode;
            }else {
                currNode.next = new ListNode(currElement.val);
                currNode = currNode.next;
            }

            // Adding new element from the polled list into the heap
            if(currElement.next != null){
                ListNode tempNode = currElement.next;
                minHeap.add(new Element(tempNode.val, tempNode.next));
            }
        }

        return headNode;
    }
}
