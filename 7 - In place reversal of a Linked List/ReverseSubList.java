/*
Given the head of a LinkedList and two positions ‘p’ and ‘q’, 
reverse the LinkedList from position ‘p’ to ‘q’.
*/

import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q){
        if(p == q)
          return head;
          
        ListNode curr = head, prev = null;
        for(int i=0; curr != null && i < p - 1; ++i){
            prev = curr;
            curr = curr.next;
        }
        
        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfSubList = curr;
        ListNode next = null;
        
        for(int i = 0; curr != null && i < q - p + 1; i++){
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
        
        return head;
    }
    public static void main(String args[]) {
      ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = ReverseSubList.reverse(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
    }
}
