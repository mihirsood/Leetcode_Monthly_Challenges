// Problem : https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
// Solution:

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        
        int cr=0;
        int cc=cols-1;
        
        while(cr<rows && cc>=0){
            if(binaryMatrix.get(cr,cc)==1){
                cc--;
            }else{
                cr++;
            }
        }
        return (cc==cols-1) ? -1:cc+1;
    }
}
