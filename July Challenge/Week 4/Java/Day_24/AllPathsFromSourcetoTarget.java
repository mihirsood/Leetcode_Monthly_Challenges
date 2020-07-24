// Problem :https://leetcode.com/problems/all-paths-from-source-to-target/
// Solution:
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        dfs(0,graph.length-1,graph,ans,res);
        return res;
    }
    private void dfs(int source,int dest,int[][] graph,List<Integer> ans,List<List<Integer>> res){
        if(source==dest){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int n : graph[source]){
            ans.add(n);
            dfs(n,dest,graph,ans,res);
            ans.remove(ans.size()-1);
        }
    }
}
