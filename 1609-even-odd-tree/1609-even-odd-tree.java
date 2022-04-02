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
    public boolean isEvenOddTree(TreeNode root) {
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int s=q.size();
            int prev=level%2==0?-(int)1e8:(int)1e8;
            if(level%2==0){
                for(int i=0;i<s;i++){
                    TreeNode rem=q.remove();
                    if(rem.val>prev && rem.val%2!=0){
                        prev=rem.val;
                        if(rem.left!=null) q.add(rem.left);
                        if(rem.right!=null) q.add(rem.right);
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                for(int i=0;i<s;i++){
                    TreeNode rem=q.remove();
                    if(rem.val<prev && rem.val%2==0){
                        prev=rem.val;
                        if(rem.left!=null) q.add(rem.left);
                        if(rem.right!=null) q.add(rem.right);
                    }
                    else{
                        return false;
                    }
                }
            }
            level++;
            //System.out.println(q+" "+level);
        }
        return true;
    }
}