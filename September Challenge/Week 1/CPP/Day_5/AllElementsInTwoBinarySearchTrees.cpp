/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void in_order(TreeNode* root, vector<int>& result)
    {
        if(root == NULL)
        {
            return;
        }
        
        in_order(root->left,result);
        result.push_back(root->val);
        in_order(root->right,result);
    }
    
    void merge_arr(vector<int>& result, vector<int>& res1, vector<int>& res2)
    {
        int len1 = res1.size();
        int len2 = res2.size();
    
        int i = 0;
        int j = 0;
        
        while(i < len1 && j < len2)
        {
            if(res1[i] < res2[j])
            {
                result.push_back(res1[i]);
                i++;
            }
            else if(res1[i] > res2[j])
            {
                result.push_back(res2[j]);
                j++;
            }
            else
            {
                result.push_back(res1[i]);
                result.push_back(res2[j]);
                i++;
                j++;
            }
            
        }
        
        if(i < len1)
        {
            for(int m = i; m < len1; m++)
            {
                result.push_back(res1[m]);
            }
        }
        
        if(j < len2)
        {
            for(int m = j; m < len2; m++)
            {
                result.push_back(res2[m]);
            }
        }
        
    
    }
    
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        
        vector<int> res1;
        vector<int> res2;
        
        vector<int> result;
        
        if(root1 == NULL && root2 == NULL)
        {
            return result;
        }
        
        if(root1 != NULL && root2 == NULL)
        {
            in_order(root1,res1);
            
            return res1;
        }
        
        if(root1 == NULL && root2 != NULL)
        {
            in_order(root2,res2);
            
            return res2;
        }
        
        in_order(root1,res1);
        in_order(root2,res2);
        
        merge_arr(result,res1,res2);
        
        return result;       
        
    }
};
