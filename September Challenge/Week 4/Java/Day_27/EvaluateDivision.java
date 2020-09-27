// Problem : https://leetcode.com/problems/evaluate-division/
// Solution:

class Solution {
    class Node{
        double val;
        String des;
        
        Node(double value, String dst){
            this.val=value;
            this.des=dst;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String,List<Node>> graph = makeGraph(equations,values);
        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            if(graph.containsKey(src)){
                res[i]=dfs(graph,src,dst,new HashSet<>());
            }
            if(res[i]<=0.0){
                res[i]=-1;
            }
        } 
        return res;
    }
    
    private double dfs(Map<String,List<Node>> graph,String src, String dest, Set<String> set){
        if(src.equals(dest)) 
            return 1;
        
        if(set.contains(src)) 
            return -1;
        
        set.add(src);
        double res=1.0;
        for(Node node:graph.get(src)){
            res=node.val*dfs(graph,node.des,dest,set);
            if(res>0){
                return res;
            }
        }
            
        return res;
    }
    private Map<String,List<Node>> makeGraph(List<List<String>> equations, double[] values){
        Map<String,List<Node>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            List<Node> l1 = graph.getOrDefault(src,new ArrayList<>());
            l1.add(new Node(values[i],dst));
            graph.put(src,l1);
            
            l1=graph.getOrDefault(dst,new ArrayList<>());
            l1.add(new Node((1.0/values[i]),src));
            graph.put(dst,l1);
        }
        return graph;
    }
}
