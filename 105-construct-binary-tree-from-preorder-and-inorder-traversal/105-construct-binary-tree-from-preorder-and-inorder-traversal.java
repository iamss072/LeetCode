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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1,0);
    }
    private TreeNode build(int[] preorder,int[] inorder,int s,int e,int ps){
        if(s>e) return null;
        TreeNode root=new TreeNode(preorder[ps]);
        int inidx=inidx(inorder,preorder[ps]);
        // System.out.println(root.val);
        root.left=build(preorder,inorder,s,inidx-1,ps+1);
        root.right=build(preorder,inorder,inidx+1,e,ps+(inidx-s+1));
        return root;
    }
    private int inidx(int[] inorder,int val){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    }
}