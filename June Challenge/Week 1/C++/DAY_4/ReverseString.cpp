void swap(char &c1 , char &c2){
    char c3=c1;
    c1=c2;
    c2=c3;
}

class Solution {
public:
    void reverseString(vector<char>& s) {
        for(int i=0;i<s.size()/2;i++){
            swap(s.at(i),s.at(s.size()-i-1));
        }
    }
};
