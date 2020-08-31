// Problem : https://leetcode.com/problems/stream-of-characters/
// Solution:

class StreamChecker {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    
    public StreamChecker(String[] words) {
        for(String s : words){
            TrieNode node = root;
            for(int i = s.length() -1;i>=0;i--){
                char c = s.charAt(i);
                if(node.child[c-'a']==null){
                    node.child[c-'a']=new TrieNode();
            }
            node = node.child[c-'a'];
        }
        node.isEnd=true;
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for(int i = sb.length()-1;i>=0;i--){
            char c = sb.charAt(i);
            node = node.child[c-'a'];
            if(node!=null && node.isEnd){
                return true;
            }
            if(node==null){
                return false;
            }
        }
        return false;
    }
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
