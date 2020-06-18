// Problem : https://leetcode.com/problems/surrounded-regions/
// Solution :

class Solution {
    int n;
    int m;
    
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0] == null || board[0].length <= 2) {
            return;
        }
        
        n = board.length;
        m = board[0].length;
        
        for(int i = 0; i < m ; i++){
            if(board[0][i]=='O'){
                BoardDFS(board,0,i);
            }
            if(board[n-1][i]=='O'){
                BoardDFS(board,n-1,i);
            }
        }
        
        for(int i = 0; i < n ; i++){
            if(board[i][0]=='O'){
                BoardDFS(board,i,0);
            }
            if(board[i][m-1]=='O'){
                BoardDFS(board,i,m-1);
            }
        }
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='.'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void BoardDFS(char[][] board,int i,int j){
        if(i < 0 || j < 0 || i > n-1 || j > m-1 ) return;
        if(board[i][j]=='O'){
        board[i][j]='.';
        BoardDFS(board,i+1,j);
        BoardDFS(board,i-1,j);
        BoardDFS(board,i,j+1);
        BoardDFS(board,i,j-1);
        }
    }
}
