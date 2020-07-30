// Problem : https://leetcode.com/problems/word-break-ii/
// Solution:
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return myDFS(s, wordDict, new HashMap<String, List<String>>());
    }   
      
    private List<String> myDFS(String s,List<String> wordDict,HashMap<String,List<String>> map){
        if(map.containsKey(s)) return map.get(s);
        
        List<String> res = new ArrayList<>();
        if(s.length()==0){
            res.add("");
            return res;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> sublist = myDFS(s.substring(word.length()),wordDict,map);
                for(String sub: sublist)
                    res.add(word+(sub.isEmpty()?"":" ")+sub);
            }
        }
        map.put(s,res);
        return res;
    }
}
