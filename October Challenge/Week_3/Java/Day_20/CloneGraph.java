// Problem : https://leetcode.com/problems/clone-graph/
// Solution:

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new Node(node.val,new ArrayList<>()));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            for(Node nbr : curr.neighbors){
                if(!map.containsKey(nbr)){
                    map.put(nbr,new Node(nbr.val, new ArrayList<>()));
                    queue.offer(nbr);
                }
                map.get(curr).neighbors.add(map.get(nbr));
            }
        }
        
        return map.get(node);
    }
}