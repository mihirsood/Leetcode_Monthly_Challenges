// Problem : https://leetcode.com/problems/combination-sum-iii/
// Solution:

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        helper(k,n,new ArrayList<>(),0,0,res);
        return res;
    }
    private void helper(int k, int n, List<Integer> curr, int idx, int sum, List<List<Integer>> res){
        if(k<0 || sum>n) return;
        if(k==0 && sum==n){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=idx+1;i<=9;i++){
            curr.add(i);
            helper(k-1,n,curr,i,sum+i,res);
            curr.remove(curr.size()-1);
        }
        
    }
}
