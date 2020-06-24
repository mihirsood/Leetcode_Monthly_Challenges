// Problem : https://leetcode.com/problems/unique-binary-search-trees/
// Solution:
class Solution {
    public int numTrees(int n) {
        int[] Tree = new int[n+1];
        Tree[0]=1;
        Tree[1]=1;
        
        for(int i = 2 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                Tree[i]+=Tree[j]*Tree[i-j-1];
            }
        }
        return Tree[n];
    }
}
