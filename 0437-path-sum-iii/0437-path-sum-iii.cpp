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
    void solve(TreeNode* root, int targetSum, long long currSum, unordered_map<long long, int> &mp, int &cnt) {
        if(root == nullptr) {
            return;
        }

        currSum += root->val;
        if(currSum == targetSum) 
            cnt++;

        if(mp.find(currSum - targetSum) != mp.end()) {
            cnt += mp[currSum - targetSum];
        }    

        mp[currSum]++;

        solve(root->left, targetSum, currSum, mp, cnt);
        solve(root->right, targetSum, currSum, mp, cnt);

        mp[currSum]--;
    }
    int pathSum(TreeNode* root, int targetSum) {
        unordered_map<long long, int> mp;
        int cnt = 0;

        solve(root, targetSum, 0, mp, cnt);
        return cnt;
    }
};