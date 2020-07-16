// Problem :https://leetcode.com/problems/powx-n/
// Solution:
class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1;
        
        if(n==Integer.MIN_VALUE && x>0) return 0;
        
        double res = 1;
        res = pow(x,n);
        
        if(n<0) res = 1/res;
        
        return res;
    }
    
    private double pow(double x, int n){
        if(n==0) return 1;
        double half=pow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}
