class Solution {
public:
    bool isSubsequence(string s, string t) {

        if(s.size()==0){
            return true;
        }
        if(s.size()>t.size()){
            return false;
        }
        int counter=0;
        for(char c: t){
            if(c==s.at(counter)){
                counter++;
            }
            if(counter==s.size()){
                return true;
            }
        }
   return false;
    }
};
