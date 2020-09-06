// Problem : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        
        getList(root1,l1);
        getList(root2,l1);
        
        Collections.sort(l1);        
        return l1;
    }
    
    private void getList(TreeNode node, List<Integer> l){
        if(node==null){
            return;
        }
        getList(node.left,l);
        l.add(node.val);
        getList(node.right,l);
    }
    
}
