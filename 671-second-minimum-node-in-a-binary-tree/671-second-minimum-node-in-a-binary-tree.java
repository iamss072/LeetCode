class Solution {
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        
        if(root == null) return -1;
        // if(root.left == null && root.right == null) return -1;
        if(root.val < min){
            secondMin = min;
            min = root.val;
            
        } 
        else  if(root.val > min && root.val <=secondMin){
            found = true;
            secondMin = root.val;
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        
        return found == true ? secondMin : -1;
    }
}