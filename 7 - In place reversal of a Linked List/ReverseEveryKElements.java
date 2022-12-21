/*
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.


Solution

The problem follows the In-place Reversal of a LinkedList pattern and is quite similar to Reverse a Sub-list. 
The only difference is that we have to reverse all the sub-lists. We can use the same approach, starting with the first sub-list (i.e. p=1, q=k) and keep reversing all the sublists of size ‘k’.
*/

import java.util.*;

class ListNode{
    int value = 0;
    ListNode next;
    
    ListNode(int value){
        this.value = value;
    }
}

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k){
        if(k <= 1 || head == null) return head;
        
        ListNode curr = head, prev = null;
        while(true){
            ListNode lastNodeOfPreviousPart = prev;
            ListNode lastNodeOfSubList = curr;
            ListNode next = null;
            
            for(int i=0; curr != null && i < k; i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(lastNodeOfPreviousPart != null){
                lastNodeOfPreviousPart.next = prev;
            }
            else{
                head = prev;
            }
            
            lastNodeOfSubList.next = curr;
            
            if(curr == null) break; // reached end of LinkedList
            
            prev = lastNodeOfSubList;
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

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
    }
}
