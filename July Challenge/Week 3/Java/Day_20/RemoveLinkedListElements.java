// Problem: https://leetcode.com/problems/remove-linked-list-elements/
//Solution:

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
    public ListNode removeElements(ListNode head, int value) {
        while(head!=null && head.val==value) head=head.next;
        if(head==null) return null;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr!=null){
            while(curr!=null && curr.val==value){
                curr=curr.next;
            }
            prev.next = curr;
            if(curr==null) break;
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}
