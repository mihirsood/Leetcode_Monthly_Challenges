class Solution {
public:
    int lengthOfLastWord(string s) {
        if(s.size()==0){
            return 0;
        }
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(count!=0 && isspace(s.at(i))){
                break;
            }
            if(!isspace(s.at(i))){
                count++;
            }
        }
        return count;
    }
};
