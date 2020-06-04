//Problem:https://leetcode.com/problems/invert-binary-tree/
//solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Invert(root);
        return root;
    }
    public static void Invert(TreeNode node){
        if(node==null){
        return;
        }
        if ((node.left==null)&&(node.right==null)){
            return;
        }
        TreeNode newnode=new TreeNode();
        newnode=node.left;
        node.left=node.right;
        node.right=newnode;
        Invert(node.left);
        Invert(node.right);
        
    }
}
