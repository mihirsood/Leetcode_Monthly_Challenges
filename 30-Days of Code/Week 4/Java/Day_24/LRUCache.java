// Problem : https://leetcode.com/problems/lru-cache/
// Solution:

class LRUCache {
    
    class DLLNode{
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
    }
    
    // add at head
    private void addNode(DLLNode node){
        node.prev=head;
        node.next=head.next;
                
        node.next.prev=node;
        head.next=node;
    }
    
    // remove from tail
    private void removeNode(DLLNode node){
        DLLNode prn = node.prev;
        DLLNode nen = node.next;
        
        prn.next=nen;
        nen.prev=prn;
    }
    
    //move to head
    private void movetoHead(DLLNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    //pop Tail
    private DLLNode popTail(){
        DLLNode res = tail.prev;
        this.removeNode(res);
        return res;
    }
    
    //____________________________________________________________________________//
    
    private HashMap<Integer, DLLNode> cache = new HashMap<>();
    private DLLNode head,tail;
    private int count;
    private int capacity;
    
    public LRUCache(int capacity) {
        count=0;
        this.capacity=capacity;
        
        head = new DLLNode();
        head.prev=null;
        
        tail=new DLLNode();
        tail.next=null;
        
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        DLLNode node = cache.get(key);
        if(node==null) return -1;
        
        this.movetoHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        if(node==null){
            DLLNode nn = new DLLNode();
            nn.value=value;
            nn.key=key;
            
            cache.put(key,nn);
            this.addNode(nn);
            
            ++count;
            if(count>capacity){
                DLLNode last = this.popTail();
                this.cache.remove(last.key);
                --count;
            }
        }else{
            node.value=value;
            this.movetoHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
