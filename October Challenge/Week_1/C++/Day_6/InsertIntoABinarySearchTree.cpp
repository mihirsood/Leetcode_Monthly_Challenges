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

void donotInsertIntoBST(TreeNode* root , int val){
    if(root==NULL){
        return ;
    }
    TreeNode* temp = new TreeNode(val);
    if(root->val>val){
        if(root->left==nullptr){
            root->left=temp;
        }else{
            donotInsertIntoBST(root->left , val);
        }
    }else
    if(root->val<val){
        if(root->right==nullptr){
            root->right=temp;
        }else{
            donotInsertIntoBST(root->right , val);
        }
    }
    return;
}

class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root==nullptr){
           TreeNode* temp = new TreeNode(val);
            return temp;
        }
        donotInsertIntoBST(root , val);
        return root;
    }
};
