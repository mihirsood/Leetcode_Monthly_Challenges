//Problem:https://leetcode.com/problems/cheapest-flights-within-k-stops/
//Solution:
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int INF = 1000000;
        int[] price = new int[n];
        Arrays.fill(price, INF);
        price[src] = 0;
        int ans = price[dst];
        for(int i = K; i >= 0; i--){
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for(int[] flight : flights){
                cur[flight[1]] = Math.min(cur[flight[1]], price[flight[0]] + flight[2]);
            }
            price = cur;
            ans = Math.min(ans, price[dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
