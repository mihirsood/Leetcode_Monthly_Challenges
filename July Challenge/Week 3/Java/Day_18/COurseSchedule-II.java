// Problem : https://leetcode.com/problems/course-schedule-ii/
// Solution:
class Solution {
    public int[] findOrder(int num, int[][] prerequisites) {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();
        
        for(int i = 0;i<num;i++){
            indegree.put(i,0);
            map.put(i, new HashSet<Integer>());
        }
        
        for(int[] course : prerequisites){
            int after = course[0];
            int before = course[1];
            Set<Integer> s = map.get(before);
            if(!s.contains(after)){
                s.add(after);
                indegree.put(after,indegree.get(after)+1);
            }
            map.put(before,s);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Integer course : indegree.keySet()){
            if(indegree.get(course)==0)
                queue.offer(course);
        }
        
        int[] res = new int[num];
        int i = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            res[i++]=course;
            if(map.containsKey(course)){
                for(int after : map.get(course)){
                    indegree.put(after,indegree.get(after)-1);
                    if(indegree.get(after)==0)
                        queue.offer(after);
                }
            }
            
        }
        return i==num ? res : new int[0];
    }
}
