// Problem : https://leetcode.com/problems/add-and-search-word-data-structure-design/
// Solution:
class WordDictionary {
    private class Node{
        char ch;
        boolean isEnd;
        HashMap<Character,Node> children;
        
        Node(char ch , boolean isEnd){
            this.ch=ch;
            this.children=new HashMap<>();
            this.isEnd=isEnd;
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('0',false);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        add(root,word,0);
    }
    
    private void add(Node root,String word,int i){
        
        if(i==word.length()){
            if(root.isEnd){
            //Word Already Added
            }else{
               root.isEnd = true; 
            }
            return ;
        }
        
        char cc = word.charAt(i);
        Node child = root.children.get(cc);
        if(child==null){
            child = new Node(cc,false);
            root.children.put(cc,child);
        }
        add(child,word,i+1);
                
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return srch(root,word,0);
    }
    
    private boolean srch(Node root,String word,int i){
        if(i==word.length()){
            if(root.isEnd){
                return true;
            }else{
                return false;
            }
        }
        char cc = word.charAt(i);
        Node child = root.children.get(cc);
        if(child==null && cc !='.'){
            return false;
        }
        else if(child!=null){
            return srch(child,word,i+1);
        }
        boolean found = false;
        Set<Map.Entry<Character,Node>> entries = root.children.entrySet();
        for(Map.Entry<Character,Node> entry : entries){
            found = found || srch(entry.getValue(),word,i+1);
            if(found) break;
        }
        return found;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
