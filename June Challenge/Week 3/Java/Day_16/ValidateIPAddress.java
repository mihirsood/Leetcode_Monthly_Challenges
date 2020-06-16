// Problem:https://leetcode.com/problems/validate-ip-address/
// Solution:
class Solution {
    public String validIPAddress(String IP) {
        if(IP.contains(".")){
            if(isIPv4(IP)){
                return "IPv4";
            }
        }
        else if(IP.contains(":")){
            if(isIPv6(IP)){
                return "IPv6";
            }
        }
        
        return "Neither";
    }
    
    private boolean isIPv4(String IP){
        if(IP.charAt(0)=='.'||IP.charAt(IP.length()-1)=='.')
            return false;
        String[] arr = IP.split("\\."); // Forming an array of string after splitting input by "." 
        if(arr.length != 4){
            return false;
        }
        
        for(String s : arr){
            if(s.length()==0 || s.length()>3)
                return false;
            
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                if(!(Character.isDigit(c)))
                    return false;
            }
            
            int val = Integer.parseInt(s); // Converting string to integer
            if((s.charAt(0)=='0') && (s.length()>1)) //leading zeroes
                return false;
            
            if((val<0) || (val>=256))   // Range of numbers
                return false;
        }
        return true;
    }
    
    private boolean isIPv6(String IP){
        if(IP.charAt(0)==':'||IP.charAt(IP.length()-1)==':')
            return false;
        String[] arr = IP.split("\\:"); // Forming an array of string after splitting input by ":" 
        if(arr.length != 8){
            return false;
        }
        
        for(String s : arr){
            if(s.length()==0 || s.length()>4)
                return false;
            
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                if(!(Character.isDigit(c) || ((c>='a') && (c<='f')) || ((c>='A') && (c<='F')) ))
                    return false;
            }
        }
        return true;
    } 
    
}
