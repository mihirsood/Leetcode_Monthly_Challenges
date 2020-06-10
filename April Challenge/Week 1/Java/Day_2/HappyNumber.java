//Problem:https://leetcode.com/problems/happy-number/
//Solution: HashSet
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visit = new HashSet<>();
        visit.add(n);
        while(n!=1){
            int sum=0;
            
            while(n!=0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            
            if(visit.contains(sum)){
                return false;
            }
            visit.add(sum);
            n=sum;
        }
        return true;
    }
}
