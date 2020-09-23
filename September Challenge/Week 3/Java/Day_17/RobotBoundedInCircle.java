// Problem : https://leetcode.com/problems/robot-bounded-in-circle/
// Solution:

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0;
        int y=0;
        char dirn='N';
        
        for(char c:instructions.toCharArray()){
            if(c=='G'){
                if(dirn=='N') y++;
                else if(dirn=='S') y--;
                else if(dirn=='E') x++;
                else x--;
            }else if(c=='L'){
                if(dirn=='N') dirn='W';
                else if(dirn=='S') dirn='E';
                else if(dirn=='E') dirn='N';
                else dirn='S';
            }else{
                if(dirn=='N') dirn='E';
                else if(dirn=='S') dirn='W';
                else if(dirn=='E') dirn='S';
                else dirn='N';
            }
        }
        
        if((dirn!='N')||(x==0 && y==0)){
            return true;
        }
        return false;
    }
}
