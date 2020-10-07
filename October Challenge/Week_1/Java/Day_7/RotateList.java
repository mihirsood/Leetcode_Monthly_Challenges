// Problem : https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode ptr = head;
        ListNode copyHead = head;
        
        int len =1;
        while(ptr.next!=null){
            ptr=ptr.next;
            len++;
        }
        k=k%len;
        if(k==0) return head;
        k=len-k;
        ptr=head;
        while(k>1){
            ptr=ptr.next;
            k--;
        }
        head=ptr.next;
        ptr.next=null;
        
        ptr=head;
        while(ptr.next!=null){
            ptr=ptr.next;
        }
        ptr.next=copyHead;
        
        return head;
    }
}