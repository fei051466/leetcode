#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void sumSubPath(struct TreeNode* root, int cur, int sum, int *result)
{
    if(root == NULL) return;
    if(cur + root->val == sum) 
    {
        *result = *result + 1;
    }
    sumSubPath(root->left, cur + root->val, sum, result);
    sumSubPath(root->right, cur + root->val, sum, result);

}

void preTra(struct TreeNode* root, int sum, int *result)
{
    if(root == NULL) return;
    sumSubPath(root, 0, sum, result);
    preTra(root->left, sum, result);
    preTra(root->right, sum, result);
}

        

int pathSum(struct TreeNode* root, int sum) {
    int result = 0;
    preTra(root, sum, &result);        
    return result;
}
