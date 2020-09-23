// Problem : https://leetcode.com/problems/sequential-digits/
// Solution:

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str="123456789";
        int nl=Integer.toString(low).length();
        int hl=Integer.toString(high).length();
        List<Integer> res= new ArrayList<>();
        
        for(int l=nl;l<=hl;l++){
            for(int si=0;si<10-l;si++){
                int num=Integer.parseInt(str.substring(si,si+l));
                if(num>high) return res;
                if(num>=low && num<=high) res.add(num);
            }
        }
        return res;
    }
}
