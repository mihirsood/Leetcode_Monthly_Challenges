
// Problem : https://leetcode.com/problems/add-and-search-word-data-structure-design/
// Solution:
class WordDictionary {
    private class Node{
        Node[] child ;
        boolean isEnd;
        Node(){
            child = new Node[26];
            isEnd = false;
        }
    }
    
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.child[c-'a']==null)
                curr.child[c-'a']=new Node();
            curr=curr.child[c-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return srch(root,word,0); 
    }
    
    private boolean srch(Node root,String word,int i){
        if(i==word.length()){
            return root.isEnd;
        }        
        
        char c = word.charAt(i);
        
        if(c == '.'){
            for(Node n : root.child){
                if(n!=null && srch(n,word,i+1))
                    return true;
            }
        }else{
            if(root.child[c-'a']!=null && srch(root.child[c-'a'],word,i+1))
                return true;
            
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
