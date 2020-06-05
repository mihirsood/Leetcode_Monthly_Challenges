class Solution {
    vector<int> acm;
    int total = 0;
public:
    Solution(vector<int> w) {
        for (int i : w) {
            total += i;
            acm.push_back(total);
        }
    }

    int pickIndex() {
        int r = rand() % total;
        auto itor = upper_bound(acm.begin(), acm.end(), r);
        return itor - acm.begin();
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */
