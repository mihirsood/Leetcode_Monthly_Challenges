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
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curlev = new LinkedList<>();
            if(level==0){
                for(int i = 0; i< size;i++){
                    TreeNode curr = queue.poll();
                    curlev.add(curr.val);
                    if(curr.left!=null) queue.offer(curr.left);
                    if(curr.right!=null) queue.offer(curr.right);
                }
            }
            else{
                for(int i = 0; i< size;i++){
                    TreeNode curr = queue.poll();
                    stack.push(curr.val);
                    if(curr.left!=null) queue.offer(curr.left);
                    if(curr.right!=null) queue.offer(curr.right);
                }
                while(!stack.isEmpty())
                    curlev.add(stack.pop());
            }
            res.add(curlev);
            level=(level==0)?1:0;
        }
        return res;
    }
}
