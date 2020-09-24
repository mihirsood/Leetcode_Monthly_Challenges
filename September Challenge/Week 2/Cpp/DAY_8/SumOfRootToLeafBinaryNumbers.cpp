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
    int findSum(TreeNode* root ,int value1){
        if(root == nullptr){
            return 0;
        }
        
        
        value1 = (value1*2) + root->val;
        if(root->left==NULL && root->right==NULL){
            return value1;
        }
        return findSum(root->left , value1) + findSum(root->right , value1);
    }
    int sumRootToLeaf(TreeNode* root) {
        
        int sum = findSum(root , 0);
        return sum;
    }
};
