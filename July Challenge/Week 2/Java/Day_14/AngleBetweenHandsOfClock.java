// Problem :https://leetcode.com/problems/angle-between-hands-of-a-clock/
// Solution:
class Solution {
    public double angleClock(int hour, int minutes) {
        double mins = minutes*6;
        double hrs = hour*30 + minutes*0.5;
        double diff = Math.abs(hrs-mins);
        return Math.min(diff,360-diff);
    }
}
