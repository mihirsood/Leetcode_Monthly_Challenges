class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        int n   = timeSeries.size();
        int sum=0;
        if(n==0){
            return 0;
        }
        if(n==1){
            return duration;
        }
        
        for(int i=1;i<n;i++){
            int val = timeSeries[i]-timeSeries[i-1];
            sum +=min(val , duration);
        }
        sum+=duration;
        return sum;
    }
};
