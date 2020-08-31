// Problem : https://leetcode.com/problems/pancake-sorting/
// Solution:
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        
        for(int currMax = A.length; currMax > 1; currMax--){
            int mi = getMax(A,currMax);
            if(mi==currMax)
                continue;
            rev(A,mi);
            res.add(mi+1);
            rev(A,currMax-1);
            res.add(currMax);
            
        }
        return res;
    }
    
    private int getMax(int[] arr, int n){
        int mi = 0;
        for(int i = 0; i<n ; i++){
            if(arr[i]>arr[mi]){
                mi = i;
            }
        }
        return mi;
    }
    
    private void rev(int[] arr, int end){
        int i =0;
        while(i<end){
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            i++;
            end--;
        }
    }
}
