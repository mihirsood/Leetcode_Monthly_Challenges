// Problem :https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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
    private class VOPair implements Comparable<VOPair>{
        int val;
        int hl;
        int vl;
        
        VOPair(int val,int hl,int vl){
            this.val=val;
            this.hl=hl;
            this.vl=vl;
        }
       
        @Override
        public int compareTo(VOPair o){
            if(this.hl==o.hl && this.vl==o.vl){
                return this.val-o.val;
            }
            return this.hl-o.hl;
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        HashMap<Integer,List<VOPair>> map = new HashMap<>();
        VOBT(root,0,0,map);
        
        ArrayList<Integer> sortlevel = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortlevel);
        
        for(int i : sortlevel){
            List<VOPair> list = map.get(i);
            Collections.sort(list);
            List<Integer> curr = new LinkedList<>();
            for(VOPair pair: list){
                curr.add(pair.val);
            }
            res.add(curr);
        }
        return res;
        
    }
    private void VOBT(TreeNode node,int vlevel,int hlevel, HashMap<Integer,List<VOPair>> map){
        if(node==null) return ;
        if(!map.containsKey(vlevel))
            map.put(vlevel,new LinkedList<>());
        
        VOPair curr = new VOPair(node.val,hlevel,vlevel);
        map.get(vlevel).add(curr);
        
        VOBT(node.left,vlevel-1,hlevel+1,map);
        VOBT(node.right,vlevel+1,hlevel+1,map);
    }
}
