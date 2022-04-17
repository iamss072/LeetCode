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
    TreeNode prev,curr;
    public TreeNode increasingBST(TreeNode root) {
        prev=new TreeNode(-1);
        curr=prev;
        traverse(root);
        return prev.right;
    }
    private void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        
        curr.right=root;
        
        root.left=null;
        curr=root;
        // System.out.println(curr.val);
        traverse(root.right);
    }
    
}