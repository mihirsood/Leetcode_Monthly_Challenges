// Problem : https://leetcode.com/problems/repeated-dna-sequences/
// Solution:

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> results = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int windowSize = 10;
        
        for (int i = 0; i <= s.length() - windowSize; i++) {
            String sub = s.substring(i, i + windowSize);
            
            if (visited.contains(sub)) {
                if (!results.contains(sub)) {
                    results.add(sub);
                }
            } else {
                visited.add(sub);
            }
        }
        
        return new ArrayList(results);
    }
}