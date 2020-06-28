//Problem : https://leetcode.com/problems/reconstruct-itinerary/
//Solution:
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        build(map,tickets);
        
        DFS(res,map,"JFK");
        
        return res;
    }
    
    private void DFS(LinkedList<String> res,HashMap<String,PriorityQueue<String>> map, String from){
        PriorityQueue<String> arrive = map.get(from);
        while(arrive != null && !arrive.isEmpty()){
            String to = arrive.poll();
            DFS(res,map,to);
        }
        
        res.addFirst(from);        
    }
    
    private void build(HashMap<String,PriorityQueue<String>> map ,List<List<String>> tickets){
        for(List<String> travel : tickets){
            String from = travel.get(0);
            String to = travel.get(1);
            
            if(!map.containsKey(from)) 
                map.put(from, new PriorityQueue<>());
            
            map.get(from).offer(to);
        }   
    }
}
