class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n<=1){
            return 0;
        }
        vector<int> maxarr(n,0);
        vector<int> minarr(n,0);
        minarr.at(0) = prices.at(0);
        maxarr.at(n-1) = prices.at(n-1);
        for(int i=1;i<n;i++){
            minarr.at(i) = min(minarr.at(i-1),prices.at(i));
        }
        for(int i=n-2;i>=0;i--){
            maxarr.at(i) = max(maxarr.at(i+1),prices.at(i));
        }
        
        int maxel=0;
        for(int i=0;i<n;i++){
            maxel = max(maxel , maxarr[i]-minarr[i]);
        }
        return maxel;
        
    }
};
