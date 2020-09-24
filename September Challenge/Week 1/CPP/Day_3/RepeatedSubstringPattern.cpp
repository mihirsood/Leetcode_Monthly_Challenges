class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        string tmp = s+s;
        /* Remove first char to avoid to match with input string which is from 0 to s.length() */
        tmp = tmp.substr(1);
        /* Remove last char to avoid to match with input string which is appended after s.length() */
        tmp = tmp.substr(0, tmp.length()-1);
        /* if the input string present then then pattern is repeated*/
        return tmp.find(s) != string::npos ? true : false;
    }
};
