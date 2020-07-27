// Problem : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null|| postorder == null) return null;
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1) ;
    }
    private TreeNode build(int[] inorder,int inS,int inE,int[] postorder,int poS,int poE){
        if(inS>inE){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[poE]);
        int index = map.get(root.val);
        root.left=build(inorder,inS,index-1,postorder,poS,poS+(index-inS)-1);
        root.right=build(inorder,index+1,inE,postorder,poE-(inE-index),poE-1);
        return root;
    }
}
