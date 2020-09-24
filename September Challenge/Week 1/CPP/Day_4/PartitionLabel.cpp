class Solution {
public:
      vector<int> partitionLabels(string S) {
        vector<pair<int, int>> A(26);
        for(int i = 0; i < 26; i++) A[i] = make_pair(-1, -1);
        // A[i] stores 'start' and 'end' index of a particular character
        for(int i = 0; i < S.length(); i++){
            int x = S[i] - 'a';
            if(A[x].first == -1) A[x].first = i;
            A[x].second = i;
        }
        sort(A.begin(), A.end());
        vector<int> ans;
        if(S.length() == 0) return ans;
        
        // skip the {-1,-1} intervals, as some characters won't appear in string 'S'
        int pass;
        for(pass = 0; A[pass].first == -1; pass++); 
        int left = A[pass].first, right = A[pass].second;
        for(int i = pass+1; i < 26; i++){
            if(A[i].first <= right) right = max(right, A[i].second);
            else{
                ans.push_back(right - left + 1);
                left = A[i].first; right = A[i].second;
            }
        }
        ans.push_back(right - left + 1);
        return ans;
    }
};
