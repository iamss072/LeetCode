/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        find(root,k);
        return ans;
    }
    int bak=0;
    int ans=-1;
    private void find(TreeNode root,int k){
        if(root==null) return;
        find(root.left,k);
        bak++;
        if(bak==k) ans=root.val;
        find(root.right,k);
    }
}