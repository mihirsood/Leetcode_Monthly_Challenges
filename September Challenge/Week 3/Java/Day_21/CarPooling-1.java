// Problem : https://leetcode.com/problems/car-pooling/
// Solution:
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for(int[] t: trips){
            for(int i=t[1];i<t[2];i++){
                arr[i]+=t[0];
            }
        }
        for(int a:arr){
            if(a>capacity)
                return false;
        }
        return true;
    }
}
