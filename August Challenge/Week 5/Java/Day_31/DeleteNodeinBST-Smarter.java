// Problem : https://leetcode.com/problems/delete-node-in-a-bst/
// Solution:
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left==null && root.right==null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode prev = getLeftMax(root.left);
                root.val = prev.val;
                root.left = deleteNode(root.left,prev.val);
            }
        }
        return root;
    }
    
    private TreeNode getLeftMax(TreeNode root){
        while(root != null && root.right != null)
            root = root.right;
        return root;
    }
}
