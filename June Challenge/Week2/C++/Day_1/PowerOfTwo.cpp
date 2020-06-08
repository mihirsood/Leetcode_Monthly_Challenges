class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        int IntNum=log2(n);
        int power = pow(2,IntNum);
        if(n==power){
            return true;
        }else{
            return false;
        }
    }
};
