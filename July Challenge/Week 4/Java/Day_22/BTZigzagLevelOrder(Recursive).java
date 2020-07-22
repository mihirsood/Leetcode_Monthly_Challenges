// Problem :https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzag(root,0,result);
        return result;
    }
    private void zigzag(TreeNode node,int level,List<List<Integer>> result){
        if(node==null) return;
        if(level==result.size()) result.add(new ArrayList<Integer>());
        if(level%2==0)
            result.get(level).add(node.val);
        else
            result.get(level).add(0,node.val);
        zigzag(node.left,level+1,result);
        zigzag(node.right,level+1,result);
    }
    
}
