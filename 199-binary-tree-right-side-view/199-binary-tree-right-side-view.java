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
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        view(root,1);
        return ans;
    }
    public void view(TreeNode root,int l){
        if(root==null) return;
        if(ans.size()<l){
            ans.add(root.val);
        }
        view(root.right,l+1);
        view(root.left,l+1);
    }
}