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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
    private TreeNode solve(TreeNode root,int low,int high){
        
        if(root==null) return root;
        
        root.left=solve(root.left,low,high);
        root.right=solve(root.right,low,high);
        
        if(root.val<low){
            return root.right;
        }
        else if(root.val>high){
            return root.left;
        }
        else{
            return root;
        }
    }
}