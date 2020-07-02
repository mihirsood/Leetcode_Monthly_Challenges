class Solution {
public:
    int arrangeCoins(int n) {
        if(n==0){
            return 0;
        }
        int i;
        for(i=1;i<n;i++){
            n-=i;
            if(n<=i){
                return i;
            }
        }
        return i;
    }
};