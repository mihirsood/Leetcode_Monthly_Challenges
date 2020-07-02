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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
            vector<vector<int>> ans ;
            if(root== NULL)
                return ans ;

            queue<TreeNode*> q ;
            q.push(root);

            list< vector <int> > l; //keep adding new elements to front in constant time ;
            l.push_back({root->val});
            int c ; 
            TreeNode *temp ;
            vector<int>li ;
            while(!q.empty()){
                c = q.size();
                li.clear(); 
                while(c--){

                    temp = q.front();
                    q.pop();
                    if(temp->left){
                        q.push(temp->left);
                        li.push_back(temp->left->val);
                    }
                    if(temp->right){
                        q.push(temp->right);
                        li.push_back(temp->right->val);
                    }
                }
                if( !li.empty()) l.push_front(li);
            }


            for(auto i=l.begin(); i!= l.end(); i++){  // return type is vector add elements to vector from list
                vector<int>v = *i ;
                ans.push_back(v);
            }

            return ans ;

        }
};