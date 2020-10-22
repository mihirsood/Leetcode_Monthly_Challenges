// Problem : https://leetcode.com/problems/counting-elements/
// Solution:

class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        int res=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
                continue;
            }        
            else if(arr[i+1]==arr[i]+1){
                res+=count+1;
            }
            count=0;
        }
        return res;
    }
}
