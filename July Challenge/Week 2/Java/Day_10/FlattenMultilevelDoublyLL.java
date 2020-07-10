// Problem:https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//Solution:
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                if(curr.next!=null){
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.next.prev=curr;
                curr.child=null;
            }else if(curr.next==null && !stack.isEmpty()){
                curr.next=stack.pop();
                curr.next.prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}
