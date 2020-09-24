class Solution {
public:
    char findTheDifference(string s, string t) {
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        for(int i=0;i<s.length();i++){
            if(s.at(i)!=t.at(i)){
                return t.at(i);
            }
        }
        return t.at(t.length()-1);
    }
};
