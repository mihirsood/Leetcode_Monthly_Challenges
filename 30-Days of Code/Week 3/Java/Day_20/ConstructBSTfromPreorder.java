// Problem :https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return makebst(preorder,0,preorder.length-1);
    }
    private TreeNode makebst(int[] preorder,int start,int end){
        if(start>end) return null;
        
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++){
            if(preorder[i]>node.val){
                break;
            }
        }
        node.left=makebst(preorder,start+1,i-1);
        node.right=makebst(preorder,i,end);
        
        return node;
    }
}
