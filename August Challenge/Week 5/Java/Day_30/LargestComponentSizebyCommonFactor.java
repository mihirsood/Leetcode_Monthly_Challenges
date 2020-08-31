// Problem : https://leetcode.com/problems/largest-component-size-by-common-factor/
// Solution:
class Solution {
    class UnionFind {
        int[] arr;
        UnionFind(int len){
            arr = new int[len];
            for(int i =0;i<len;i++){
                arr[i]=i;
            }
        }
        
        void union(int x,int y){
            arr[find(x)]=arr[find(y)];
        }
        
        int find(int x){
            if(x!=arr[x]){
                arr[x]=find(arr[x]);
            }
            return arr[x];
        }
    }
    
    public int largestComponentSize(int[] A) {
        int max = Integer.MIN_VALUE;
        
        for(int  val : A){
            max = Math.max(max,val);
        }
        UnionFind uf = new UnionFind(max+1);
        for(int a: A){
            for(int i=2;i<=Math.sqrt(a);i++){
                if(a%i==0){
                    uf.union(a,i);
                    uf.union(a,a/i);
                }
            }
        }
        int count=1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:A){
            int parent = uf.find(a);
            map.put(parent,map.getOrDefault(parent,0)+1);
            count=Math.max(count,map.get(parent));
        }
        return count;
    }
}
