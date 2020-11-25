// Problem : https://leetcode.com/problems/asteroid-collision/
// Solution:

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i=1;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        while(i<asteroids.length){
            if(stack.isEmpty()){
                stack.push(asteroids[i++]);
                continue;
            }
            int top = stack.peek();
            if(top<0){
                stack.push(asteroids[i++]);
            }else{
                if(asteroids[i]>0){
                    stack.push(asteroids[i++]);
                }else{
                    //collide
                    int first = stack.pop();
                    int second = -1*asteroids[i];
                    if(first==second){
                        i++;
                    }else if(first>second){
                        stack.push(first);
                        i++;
                    }else{
                        continue;
                    }
                }
            }
        }
        
        int size = stack.size();
        int[] res = new int[size];
        for(i=size-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}