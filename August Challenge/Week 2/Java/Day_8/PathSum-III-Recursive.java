// Problem : https://leetcode.com/problems/path-sum-iii/
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
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return pathSum(root.left,sum) + pathSum(root.right,sum) + helper(root,sum);
    }
    private int helper(TreeNode root, int sum){
        if(root==null) return 0;
        return ((sum==root.val)?1:0) + helper(root.left,sum-root.val) + helper(root.right,sum-root.val);
    }
}
