//Problem :https://leetcode.com/problems/prison-cells-after-n-days/
//Solution:
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N-1) % 14 + 1;
        while(N>0){
            int temp[] = new int[8];
                for(int i = 1 ; i < 7 ; i++)
                    temp[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
            cells=temp;
            N--;
        }
        return cells;
    }
}
