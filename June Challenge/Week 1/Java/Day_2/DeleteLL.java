//Problem:https://leetcode.com/problems/delete-node-in-a-linked-list/
//Solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val=temp.val;
        node.next=temp.next;
        

    }
}
