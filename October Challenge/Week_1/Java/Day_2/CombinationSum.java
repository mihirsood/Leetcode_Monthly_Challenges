// Problem : https://leetcode.com/problems/combination-sum/
// Solution:

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        calc(candidates,target,0,new ArrayList<>());
        return res;
    }
    
    private void calc(int[] candidates, int target,int index, ArrayList<Integer> cres){
        if(target==0){
            res.add(new ArrayList<>(cres));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]<=target){
                cres.add(candidates[i]);
                calc(candidates,target-candidates[i],i,cres);
                cres.remove(cres.size()-1);
            }
        }
    }
}