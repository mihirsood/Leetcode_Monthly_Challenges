// Problem :https://leetcode.com/problems/diameter-of-binary-tree/
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        depth(root);
        return max;
    }
    private int depth(TreeNode node){
        if(node==null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        max=Math.max(max,l+r);
        return Math.max(l,r)+1;
    }
}
