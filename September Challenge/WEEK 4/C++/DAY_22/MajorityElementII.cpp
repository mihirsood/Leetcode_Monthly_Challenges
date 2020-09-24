class Solution {
public:

vector<int> majorityElement(vector<int>& nums) {

    int x=-1;
    int y=-1;
    
    int countx=0;
    int county=0;
    
    for(int i=0;i<nums.size();i++)
    {
        if(x==nums[i]) countx++;
        
        else if(y==nums[i]) county++;
        
        else if(countx==0)
        {
            x=nums[i];
            countx=1;
        }
        else if(county==0)
        {
            y=nums[i];
            county=1;
        }
        else
        {
            county--;
            countx--;
        }
    }
    
    int count=nums.size()/3;
    countx=0; county=0;
    
    for(int i=0;i<nums.size();i++)
    {
        if(x==nums[i])
        {
            countx++;
        }
        else if(y==nums[i])
        {
            county++;
        }
    }
    
    vector<int> v;
    
    if(countx>count)
    {
        v.push_back(x);
    }
    
    if(county>count)
    {
        v.push_back(y);
    }
    
    return v;
    
}
};
