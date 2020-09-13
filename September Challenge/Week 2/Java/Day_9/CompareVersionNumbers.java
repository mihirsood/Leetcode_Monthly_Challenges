// Problem : https://leetcode.com/problems/compare-version-numbers/
// Solution:
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        
        while(i<arr1.length && j <arr2.length){
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[j]);
            // System.out.println(a+" "+b);
            
            if(a!=b){
                if(a<b) 
                    return -1;
                else 
                    return 1;
            }
            i++;
            j++;
        }
        
        while(i<arr1.length){
            int a = Integer.parseInt(arr1[i]);
            if(a!=0){
                return 1;
            }
            i++;
        }
        
        while(j<arr2.length){
            int b = Integer.parseInt(arr2[j]);
            if(b!=0){
                return -1;
            }
            j++;
        }
        
        return 0;
    }
}
