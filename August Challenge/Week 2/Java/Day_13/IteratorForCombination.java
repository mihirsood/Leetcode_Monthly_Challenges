// Problem : https://leetcode.com/problems/iterator-for-combination/
// Solution:

class CombinationIterator {
    String s;
    Queue<String> queue;
    private void getInterations(int start, int len, StringBuilder sb){
        
        if(len==0){
            queue.add(sb.toString());
            return;
        }
        
        for(int i=start; i<=s.length()-len; i++){
            sb.append(s.charAt(i));
            getInterations(i+1,len-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        queue = new LinkedList<>();
        getInterations(0,combinationLength,new StringBuilder());
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
