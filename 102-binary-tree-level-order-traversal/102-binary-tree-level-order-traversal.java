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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        while(q.size()!=0)
        {
            int tr=q.size();
            List<Integer> sans=new ArrayList<>();
            for(int i=0;i<tr;i++)
            {
                TreeNode node=q.remove();
                sans.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add(sans);
        }
        return ans;
    }
}