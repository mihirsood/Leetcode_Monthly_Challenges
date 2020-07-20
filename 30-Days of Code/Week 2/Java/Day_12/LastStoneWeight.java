// Problem : https://leetcode.com/problems/last-stone-weight/
// Solution:
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) heap.offer(i);
        int x,y;
        while(heap.size()>1){
            y=heap.poll();
            x=heap.poll();
            if(x!=y){
                heap.offer(y-x);
            }
        }
        return heap.size()==0 ? 0 : heap.poll();
    }
}
