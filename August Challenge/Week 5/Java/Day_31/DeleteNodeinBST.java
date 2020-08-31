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
        
        if(root.val==key){
            if(root.left==null) root = root.right;
            else if(root.right==null) root = root.left;
            else delete(root,null,false,key);
        }
        else{
            delete(root,null,false,key);
        }
        return root;
    }
    
    private void delete(TreeNode root, TreeNode parent, boolean ilc, int key){
        if(root==null) return;
        
        if(root.val < key){
            delete(root.right,root,false,key);
        }
        else if(root.val > key){
            delete(root.left,root,true,key);
        }
        else{
            if(root.left == null && root.right == null){
                if(ilc){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
            }
            
            else if(root.left == null && root.right != null){
                if(ilc){
                    parent.left=root.right;
                }else{
                    parent.right=root.right;
                }
            }
            
            else if(root.left != null && root.right == null){
                if(ilc){
                    parent.left=root.left;
                }else{
                    parent.right=root.left;
                }
            }
            
            else{
                TreeNode ans = max(root.left);
                root.val = ans.val;
                delete(root.left,root,true,ans.val);
            }
        }
    }
    
    private TreeNode max(TreeNode node){
        while (node!=null && node.right!=null){
            node = node.right;
        }
        return node;
    }
}
