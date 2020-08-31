// Problem : https://leetcode.com/problems/implement-rand10-using-rand7/
// Solution:
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int val = 40;
        while(val>=40)
            val = (rand7()-1)*7 + rand7()-1;
        return val%10 + 1;
    }
}
