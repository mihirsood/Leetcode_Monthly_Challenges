class Solution {
public:
    bool wordPattern(string pattern, string str) {
        stringstream s(str);
        map<char , string> mp;
        map<string , char> mp2;
        int i=0;
        string word;
        while(s>>word){
            if(mp.find(pattern[i])==mp.end()){
                mp[pattern[i]]=word;
            }else{
                if(mp[pattern[i]]!=word){
                    return false;
                }
            }
            
            
            if(mp2.find(word)==mp2.end()){
                mp2[word]=pattern[i];
            }else{
                if(mp2[word]!=pattern[i]){
                    return false;
                }
            }
            
            if(i==pattern.size()){
                return false;
            }
            
            i++;
        }
        if(i<pattern.size()){
            return false;
        }
        return true;
        
    }
};
