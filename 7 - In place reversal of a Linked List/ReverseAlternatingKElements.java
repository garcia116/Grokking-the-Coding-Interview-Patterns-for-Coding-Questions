/*
Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.



*/

import java.util.*;

class ListNode{
    int value = 0;
    ListNode next;
    
    ListNode(int value){
        this.value = value;
    }
}

public class ReverseAlternatingKElements {
    
    public static ListNode reverse(ListNode head, int k){
        if(k <= 1 || head == null) return head;
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode lastNodeOfFirstPart = prev;
            ListNode lastNodeOfSubList = curr;
            
            ListNode next = null;
            for(int i=0; curr != null && i < k; i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            if(lastNodeOfFirstPart != null){
                lastNodeOfFirstPart.next = prev;
            }
            else{
                head = prev;
            }
            
            lastNodeOfSubList.next = curr;
            
            for(int i=0; curr != null && i < k; i++){
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
    public static void main(String args[]) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseAlternatingKElements.reverse(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
    }
}
