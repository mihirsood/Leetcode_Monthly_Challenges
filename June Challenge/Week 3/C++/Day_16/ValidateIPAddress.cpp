    bool isNum(string s){
        for(char c: s){
            if(!isdigit(c)){
                return false;
            }
        }
        return true;
    }

    bool isAlNum(string s){
        for(char c: s){
            if(!isxdigit(c)){
                return false;
            }
        }
        return true;
    }


class Solution {
public:
    string validIPAddress(string IP) {
        if(IP.find('.') != std::string::npos){
            std::stringstream ss(IP);
            std::string s;
            if(IP[IP.size()-1] == '.'){
               return "Neither";
            }
            int counter =0;
            while (std::getline(ss, s, '.')) {
                counter++;
                if((s.size() > 3 || s.size() < 1) || (s[0] == '0' && s.size() >1) || !isNum(s) || stoi(s) >255){
                    return "Neither";
                }
            }
            //cout << counter;
            return (counter == 4) ?"IPv4": "Neither";

        }

        else if(IP.find(':') != std::string::npos){
            std::stringstream ss(IP);
            std::string s;
            int counter =0;
            if(IP[IP.size()-1] == ':'){
               return "Neither";
            }
            while (std::getline(ss, s, ':')) {
                counter++;
                if((s.size() > 4 || s.size() < 1) || !isAlNum(s)){
                    return "Neither";
                }
            }
            return (counter == 8) ?"IPv6": "Neither";
        } else{
             return "Neither";
        }
    }

};
