class Codec {

	public:

	// Encodes a tree to a single string.

	void helper(TreeNode* root, string &ans)
	{
		if(root==NULL)
    {
        return;
    }
    
    ans+=to_string(root->val);
    ans+='#';
    
    helper(root->left,ans);
    helper(root->right,ans);
    
    return;
	
	}

	string serialize(TreeNode* root) {
    
    string ans="";
    
    helper(root,ans);
    
    return ans;
    
}

	// Decodes your encoded data to tree.

	TreeNode* helper2(TreeNode* root,int value)
	{
		if(root==NULL)
		{
			TreeNode* temp=new TreeNode(value);
			return temp;
		}
    
		if(value<=root->val)
		{
			root->left=helper2(root->left,value);
		}
    
		else
		{
			root->right=helper2(root->right,value);
		}
    
		return root;
	}


	TreeNode* deserialize(string data) {
    
    int i=0;
    TreeNode* root=NULL;
    while(i<data.length())
    {
        string temp="";
        
        while(i<data.length() and data[i]!='#')
        {
            temp+=data[i];
            i++;
        }
        
        i++;
        
        root=helper2(root,stoi(temp));
    }
    
    return root;
    
}
};
