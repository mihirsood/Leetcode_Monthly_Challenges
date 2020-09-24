class Solution 
{
public:
    //Create a Trie Node which is store two address left and right depending the value of ith bit.
    struct TrieNode
    {
        TrieNode* left;
        TrieNode* right;
    };
/*To create a trie first we create a head node then insert all value of array one by one. in insertion we works on 32 bits becuase array elements is 0<=ai<2^31.then we start from last bit and check if ith bit is 1 or 0 if ith bit is 1 then we move right side if ith bit is 0 then left side and if require node is not present in trie then create require node.*/             
    void insert(TrieNode* curr, int n)
    {
        for(int i=31;i>=0;i--)
        {
            int b=(n>>i)&1;
            if(b)
            {
                if(!curr->right)
                {
                    curr->right = new TrieNode();
                }
                curr = curr->right;
            }
            else
            {
                if(!curr->left)
                {
                    curr->left = new TrieNode();
                }
                curr= curr->left;
            }
        }
    }
    /* to find Maximum xor pair we take all elements of array one by one and take maximum xor pair corresponding that elements of array and then compare maxi xor pair value before till that pair. */
    int find(TrieNode* head, vector<int>& nums)
    {
        int maxi = INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            TrieNode* tmp = head;
            int cur = 0;
            for(int j=31;j>=0;j--)
            {
                int b = (nums[i]>>j)&1;
                if(b)
                {
                    if(tmp->left)
                    {
                        cur += pow(2,j);
                        tmp = tmp->left;
                    }
                    else
                        tmp = tmp->right;
                }
                else
                {
                    if(tmp->right)
                    {
                        cur += pow(2,j);
                        tmp = tmp->right;
                    }
                    else
                        tmp = tmp->left;
                }
            }
            if(maxi<cur) 
            {
                maxi=cur;
            }
        }
        return maxi;
    }
    int findMaximumXOR(vector<int>& nums)
    {
        TrieNode* head = new TrieNode();
        for(int i=0;i<nums.size();i++)
        {
            insert(head,nums[i]);
        }
        int res = find(head,nums);
        if(res == INT_MIN) 
        {
            return 0;
        }
        return res;
    }
};
