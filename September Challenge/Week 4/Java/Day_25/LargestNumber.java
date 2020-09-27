// Problem : https://leetcode.com/problems/largest-number/
// Solution:
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] stra=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            stra[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(stra,new Comparator<String>(){
            @Override
            public int compare(String i, String j){
                String s1=i+j;
                String s2=j+i;
                return s2.compareTo(s1);
            }
        });
        
        if(stra[0].equals("0")){
            return "0";
        }
        
        for(int i=0;i<stra.length;i++){
            sb.append(stra[i]);
        }
        
        return sb.toString();
    }
}
