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

TreeNode* myTree(TreeNode* root , int val){
    if(root==NULL){
        return nullptr;
    }
    if(root->val == val){
        return root;
    }
    return (root->val<val)?myTree(root->right,val):myTree(root->left ,val);

}
class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        return myTree(root , val);
    }
};
