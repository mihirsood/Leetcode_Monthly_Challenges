// Problem : https://leetcode.com/problems/bulls-and-cows/
// Solution:

class Solution {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cow=0;
        char[] s=secret.toCharArray();
        char[] g=guess.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length;i++){
            if(s[i]==g[i]){
                g[i]='*';
                bull++;
            }else{
                map.put(s[i],map.getOrDefault(s[i],0)+1);
            }
        }
        for(int i=0;i<g.length;i++){
            if(g[i]!='*' && map.containsKey(g[i])){
                if(map.get(g[i])>0){
                    map.put(g[i],map.get(g[i])-1);
                    cow++;
                }
            }
        }
        return bull+"A"+cow+"B";
    }
}
