// Problem : https://leetcode.com/problems/word-search/
// Solution:

class Solution {
    public boolean exist(char[][] board, String word) {
        int len=board.length;
        int wid=board[0].length;
        char[] array = word.toCharArray();
        for(int i=0;i<len;i++){
            for(int j=0;j<wid;j++){
                if(array[0]==board[i][j] && search(board,i,j,array,0,len,wid))
                    return true;                    
            }
        }
        return false;
    }
    
    private boolean search(char[][] board,int i,int j,char[] word,int idx,int len,int wid){
        if(idx==word.length)
            return true;
        
        if(i<0 || j<0 || i>=len || j>=wid || board[i][j]!=word[idx]) 
            return false;
        
        char temp = board[i][j];
        board[i][j]='#';
        boolean res = (search(board,i-1,j,word,idx+1,len,wid)||
           search(board,i+1,j,word,idx+1,len,wid)||
           search(board,i,j-1,word,idx+1,len,wid)||
           search(board,i,j+1,word,idx+1,len,wid));
        
        board[i][j]=temp;
        
        return res;
        
    }
}
