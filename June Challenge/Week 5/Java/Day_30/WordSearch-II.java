//Problem :https://leetcode.com/problems/word-search-ii/
//Solution:
class Solution {
    class TrieNode{
        String word;
        TrieNode[] child = new TrieNode[26];
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board,int i,int j ,TrieNode p,List<String> res){
        char c = board[i][j];
        if (c == '#' || p.child[c - 'a'] == null) return;
        p = p.child[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode curr = root;
            
            for(char c : s.toCharArray()){
                int i = c - 'a';
                if(curr.child[i]==null) 
                    curr.child[i] = new TrieNode();
                curr = curr.child[i];
            }
            curr.word=s;
        }
        return root;
    }
}
