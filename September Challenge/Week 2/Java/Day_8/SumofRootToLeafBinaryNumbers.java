// Problem : https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
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
    int tot;
    public int sumRootToLeaf(TreeNode root) {
        tot=0;
        calc(root,0);
        return tot;
    }
    
    private void calc(TreeNode node, int sumsf){
        if(node==null) return;
        int sum = 2*sumsf + node.val;
        if(node.left==null && node.right==null){
            tot+=sum;
            return;
        }
        calc(node.left,sum);
        calc(node.right,sum);
    }
}
