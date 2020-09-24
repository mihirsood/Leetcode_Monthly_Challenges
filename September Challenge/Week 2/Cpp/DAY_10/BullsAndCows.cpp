class Solution {
public:
    string getHint(string secret, string guess) {
        vector<int> v(10,0);
        int bulls=0,cows=0;
        for(int i=0;i<secret.length();i++){
            int s = (int)(secret[i]-'0');
            if(secret[i]==guess[i]){
                bulls++;
            }
            v[s]++;
        }
        for(int i=0;i<guess.length();i++){
            int g = (int)(guess[i]-'0');
            if(v[g]>0){
                v[g]--;
                cows++;
            }
        }
        cows=cows-bulls;
        string s =to_string(bulls) + "A" + to_string(cows) + "B";
        return s;
        
    }
};
