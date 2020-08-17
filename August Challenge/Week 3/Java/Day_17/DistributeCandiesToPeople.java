// Problems : https://leetcode.com/problems/distribute-candies-to-people/
// Solution :
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int count=1;
        while(candies>0){
            for(int i = 0; i<res.length ;i++){
                if(count<=candies){
                    res[i]+=count;
                    candies-=count;
                    count++;
                }else{
                    res[i]+=candies;
                    candies=0;
                }
            }
        }
        return res;
    }
}
