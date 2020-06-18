class Solution {
public:
    int hIndex(vector<int>& citations) {
        int N=citations.size();
        if(!N){
            return 0;
        }
        for(int i=0;i<N;i++){
            if(citations.at(i)>=N-i){
                return N-i;
            }
        }
        return 0;
    }
};
