// Problem : https://leetcode.com/problems/pascals-triangle-ii/
// Solution:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex+1];
        Arrays.fill(arr,1);
        for(int i = 1; i < arr.length -1 ; i++){
            for(int j = i; j>0 ; j--){
                arr[j]+=arr[j-1];
            }
        }
        return Arrays.asList(arr);
    }
}
