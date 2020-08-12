// Problem : https://leetcode.com/problems/pascals-triangle-ii/
// Solution:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long coeff = 1;
        for(int i = 0 ; i<=rowIndex ; i++){
            res.add((int)coeff);
            coeff = coeff * (rowIndex - i)/(i+1);
        }
        return res;
    }
}
