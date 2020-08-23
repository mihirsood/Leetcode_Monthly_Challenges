// Problem : https://leetcode.com/problems/reorder-list/
// Solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = rev(slow.next);
        slow.next=null;
        
        slow = head;
        while(fast!=null){
            ListNode temp1 = slow.next;
            ListNode temp2 = fast.next;
            
            slow.next=fast;
            fast.next=temp1;
            
            slow = temp1;
            fast = temp2;
        }
        
    }
    private ListNode rev(ListNode node){
        ListNode prev = null; 
        ListNode current = node; 
        ListNode next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    }
    
}
