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
    TreeNode* createParentMapping(TreeNode* root, int start, unordered_map<TreeNode*, TreeNode*> &nodeToParent) {
        TreeNode* res = NULL;

        queue<TreeNode*> q;
        q.push(root);

        nodeToParent[root] = NULL;

        while(!q.empty()) {
            TreeNode* front = q.front();
            q.pop();

            if(front->val == start) {
                res = front;
            }

            if(front->left) {
                q.push(front->left);
                nodeToParent[front->left] = front;
            }

            if(front->right) {
                q.push(front->right);
                nodeToParent[front->right] = front;
            }
        }
        return res;
    }

    int spreadTree(TreeNode* root, unordered_map<TreeNode*, TreeNode*> &nodeToParent) {
        unordered_map<TreeNode*, bool> visited;

        queue<TreeNode*> q;
        q.push(root);

        visited[root] = true;

        int time = 0;
        while(!q.empty()) {
            bool flag = 0;

            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode* front = q.front();
                q.pop();

                if(front->left && !visited[front->left]) {
                    flag = 1;
                    visited[front->left] = true;
                    q.push(front->left);
                }

                if(front->right && !visited[front->right]) {
                    flag = 1;
                    visited[front->right] = true;
                    q.push(front->right);
                }

                if(nodeToParent[front] && !visited[nodeToParent[front]]) {
                    flag = 1;
                    visited[nodeToParent[front]] = true;
                    q.push(nodeToParent[front]);
                }
            }
            if(flag == 1) {
                time++;
            }
        }
        return time;
    }
    int amountOfTime(TreeNode* root, int start) {
        unordered_map<TreeNode*, TreeNode*> nodeToParent;
        TreeNode* target = createParentMapping(root, start, nodeToParent);

        int ans = spreadTree(target, nodeToParent);

        return ans;
    }
};