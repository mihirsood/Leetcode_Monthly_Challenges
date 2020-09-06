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
        List<Integer> l2 = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        getList(root1,l1);
        getList(root2,l2);
        
        res=mergeLists(l1,l2,res);
        
        return res;
    }
    
    private void getList(TreeNode node, List<Integer> l){
        if(node==null){
            return;
        }
        getList(node.left,l);
        l.add(node.val);
        getList(node.right,l);
    }
    
    private List<Integer> mergeLists(List<Integer> l1, List<Integer> l2, List<Integer> res){
        while(!l1.isEmpty() && !l2.isEmpty()){
            if(l1.get(0)<l2.get(0)){
                res.add(l1.remove(0));
            }else{
                res.add(l2.remove(0));
            }
        }
        
        while(!l1.isEmpty()){
            res.add(l1.remove(0));
        }
        
        while(!l2.isEmpty()){
            res.add(l2.remove(0));
        }
        
        return res;
    }
}
