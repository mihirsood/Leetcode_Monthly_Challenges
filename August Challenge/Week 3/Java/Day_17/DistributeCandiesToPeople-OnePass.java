// Problems : https://leetcode.com/problems/distribute-candies-to-people/
// Solution :
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        
        int lo = 0;
        int hi = candies;
        int count = 0;
        
        while(lo<=hi){
            long mid = lo+(hi-lo)/2;
            long sum = (mid*(mid+1))/2;
            if(sum<=candies){
                count = (int)(mid/num_people); 
                // count*num = complete rectangle till last completely filled row
                lo=(int)(mid+1);
            }else{
                hi=(int)(mid-1);
            }
        }
        
        // Last used cell
        int last = count*num_people;

        //Remaining Candies
        candies-= (last*(last+1))/2;
        
        // Distribute the remaining candies first;
        // next cell will recieve last+1 candy;
        
        last+=1;
        
        for(int i = 0 ;i<res.length;i++){
            if(last<=candies){
                res[i]=last;
                candies-=last;
                last++;
            }else{
                res[i]+=candies;
                candies=0;
            }
        }
        
        for(int i =0 ;i<res.length;i++){
            res[i]+=(count*(i+1)) + (num_people*((count-1)*(count))/2);
        }
        
        return res;
    }
}
