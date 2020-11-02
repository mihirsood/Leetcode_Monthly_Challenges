// Problem : https://leetcode.com/problems/serialize-and-deserialize-bst/
// Solution:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurS(root, sb);
        return sb.toString();
    }
    
    private void recurS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        sb.append(',');
        recurS(node.left, sb);
        recurS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return recurD(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode recurD(Queue<String> queue, int min, int max) {
        if (queue.size() <= 0) {
            return null;
        }
        int val = Integer.parseInt(queue.peek());
        if (val <=  min || val >= max) {
            return null;
        }
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = recurD(queue, min, val);
        node.right = recurD(queue, val, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;