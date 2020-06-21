// Problem : https://leetcode.com/problems/permutation-sequence/
// Solution:
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n+1];
        StringBuilder sb = new StringBuilder();
        
        fact[0]=1;
        for(int i = 1; i< n+1 ;i++ ){
            fact[i]=fact[i-1]*i;
            nums.add(i);
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0, l = k - 1; i < n; i++) {
            int index = l / fact[n - 1 - i];
            ans.append(nums.remove(index));
            l = l - index * fact[n - 1 - i];
        }
        return ans.toString();

    }
}
