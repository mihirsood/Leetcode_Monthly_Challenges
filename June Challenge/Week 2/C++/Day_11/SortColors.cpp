class Solution {
public:
    void sortColors(vector<int>& arr) {
            int n=arr.size();
            int j=n-1;
            int start=0;
            int end=n-1;
            while(start<=end){
                if(arr[end]==2){
                    int t=arr[end];
                    arr[end]=arr[j];
                    arr[j]=t;
                    end--;
                    j--;
                }
                else if(arr[end]==0){
                    int t=arr[end];
                    arr[end]=arr[start];
                    arr[start]=t;
                    start++;
                }
                else{
                    end--;
                }
            }
    }
};
