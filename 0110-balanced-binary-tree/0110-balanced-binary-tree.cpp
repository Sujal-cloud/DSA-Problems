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
private:
    int dfHeight(TreeNode* node) {
        if(!node) return 0;

        int lHeight = dfHeight(node->left);
        if(lHeight == -1) return -1;

        int rHeight = dfHeight(node->right);
        if(rHeight == -1) return -1;

        if(abs(lHeight - rHeight) > 1) return -1;

        return 1 + max(lHeight, rHeight);
    }
public:    
    bool isBalanced(TreeNode* root) {
        return dfHeight(root) != -1;
    }
};