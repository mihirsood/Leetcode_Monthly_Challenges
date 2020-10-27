// Problem : https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root,arr,0);
    }
    private boolean helper(TreeNode root, int[] arr, int idx){
        if(root==null || idx==arr.length) return false;
        
        if(root.val==arr[idx]){
            if(idx==arr.length-1 && root.left==null && root.right==null)
                return true;
            
            return helper(root.left,arr,idx+1) || helper(root.right,arr,idx+1);
        }
        
        return false;
    }
}
