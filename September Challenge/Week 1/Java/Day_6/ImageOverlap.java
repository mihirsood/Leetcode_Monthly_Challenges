// Problem : https://leetcode.com/problems/image-overlap/
// Solution:

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int xStart = 0 - A.length;
        int yStart = 0 - A.length;
        xStart++;
        yStart++;
        int max=Integer.MIN_VALUE;
        for(int i = xStart; i<A.length;i++){
            for(int j = yStart; j<A.length;j++){
                max=Math.max(max,getOverlap(A,B,i,j));
            }
        }
        return max;
    }
    
    private int getOverlap(int[][] A, int[][] B, int X, int Y){
        int count=0;
        int idash=0;
        int jdash=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                idash = i-X;
                jdash = j-Y;
                if(idash<0 || idash>=A.length || jdash<0 || jdash>=A.length) 
                    continue;
                if((A[i][j]&B[idash][jdash])==1){
                    count++;
                }
            }
        }    
        return count;
    }
}
