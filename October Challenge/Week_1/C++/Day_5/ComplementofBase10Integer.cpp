class Solution {
public:
    int bitwiseComplement(int N) {
        string v;
        if(N==0){
            return 1;
        }
        while(N>0){
            int n=N%2;
            if(n==1){
                v= v+ "0";
            }else{
                v=v+"1";
            }
            N/=2;
        }
        
        long long int value=0;
        long long int p=1;
        for(auto c: v){
            value = value + (p*((int)(c-'0')));
            //cout<<value<<endl;
            p*=2;
        }
        //cout<<v<<endl;
        return value;
    }
};
