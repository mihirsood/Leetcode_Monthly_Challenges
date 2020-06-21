// Problem : https://leetcode.com/problems/dungeon-game/
// Solution:
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if((dungeon == null)||(dungeon.length == 0)||(dungeon[0].length==0))
            return 1;
        
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] InMin = new int[M][N];
        
        InMin[M-1][N-1] = 1 - dungeon[M-1][N-1];
        InMin[M-1][N-1] = InMin[M-1][N-1] <= 0 ? 1 : InMin[M-1][N-1] ; 
        
        for(int r = M-1 ; r >= 0 ; r--){
            for(int c = N-1 ; c >= 0 ; c--){
                if((r == M-1) && (c == N-1)) continue;
                int D = r + 1 == M ? Integer.MAX_VALUE : InMin[r+1][c]-dungeon[r][c];
                int R = c + 1 == N ? Integer.MAX_VALUE : InMin[r][c+1]-dungeon[r][c];
                int Health = Math.min(D,R);
                InMin[r][c] = Health <= 0 ? 1 : Health;
            }
        }
        
        return InMin[0][0];
    }
}
