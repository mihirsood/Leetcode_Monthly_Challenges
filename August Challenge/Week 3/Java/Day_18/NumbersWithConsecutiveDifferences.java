// Problem : https://leetcode.com/problems/numbers-with-same-consecutive-differences/
// Solution:

class Solution {
    List<Integer> res ;
    public int[] numsSameConsecDiff(int N, int K) {
        res = new ArrayList<>();
        if(N==1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        
        for(int i = 1; i< 10 ; i++){
            dfs(N,K,i);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private void dfs (int N, int K, int cur){
        if(N==1){
            res.add(cur);
            return;
        }
        int next = cur%10 + K;
        if( next < 10){
            dfs(N-1,K,cur*10+next);
        }
        
        int prev = next - 2*K;
        if(K!=0 && prev>=0){
            dfs(N-1,K,cur*10+prev);
        }
    }
}
