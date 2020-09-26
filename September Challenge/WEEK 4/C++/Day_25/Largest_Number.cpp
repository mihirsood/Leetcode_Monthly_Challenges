class Solution {

public:

static bool check(string &s1 , string &s2)
{
    return (s1+s2)>=(s2+s1);
}



string largestNumber(vector<int>& nums) {
    
    
    // checking whether all the values are 0s or not
    int x=0;
    
    for(int i=0;i<nums.size();i++)
    {
        if(nums[i]==0)
        {
            x++;
        }
    }
    
    // if all the values are 0 we will return "0"
    if(x==nums.size()) return "0";
    
    
    // as the input is very large we have to use string array
    vector<string> s(nums.size(),"");
    
    for(int i=0;i<nums.size();i++)
    {
        s[i]=to_string(nums[i]);
    }
    
    
    // we will sort our string array based on custum comparator
    sort(s.begin(),s.end(),check);
    
    // append the ans of sorted array in ans variable.
    string ans="";
    
    for(int i=0;i<s.size();i++)
    {
        ans+=(s[i]);
    }
    
    
    
    return ans;
    
    
}
};
