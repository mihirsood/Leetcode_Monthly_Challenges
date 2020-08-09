// Problem :https://leetcode.com/problems/rotting-oranges/
// Solution:
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int count_fresh =0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0) return 0;
        int minute=0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            minute++;
            int size = queue.size();
            for(int i = 0; i<size ; i++){
                int[] curr = queue.poll();
                
                for(int[] dr : dir){
                    int x = curr[0]+dr[0];
                    int y = curr[1]+dr[1];
                    
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=1)
                        continue;
                    grid[x][y]=2;
                    count_fresh--;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return (count_fresh==0)?minute-1:-1;
    }
}
