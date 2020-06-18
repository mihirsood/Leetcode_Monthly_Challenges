// Problem : https://leetcode.com/problems/h-index-ii/
// Solution :
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0)
            return 0;
        
        int l = 0;
        int r = citations.length-1;
        int n = r + 1 ;
        while(l<=r){
            int mid = (l+r)/2;
            if(citations[mid] >= n-mid ){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return n - l;
    }
}
