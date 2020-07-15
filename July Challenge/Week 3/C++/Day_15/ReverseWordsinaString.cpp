class Solution {
public:
    string reverseWords(string s) {
        stringstream str(s);
        vector<string> v;
        string word;
        while(str>>word){
            v.push_back(word);
        }
        reverse(v.begin() , v.end());
        s="";
        for(int i=0;i<v.size();i++){
            string c=v.at(i);
            s+=c;
            if(i!=v.size()-1)
                s+=" ";
        }
        return s;
    }
};