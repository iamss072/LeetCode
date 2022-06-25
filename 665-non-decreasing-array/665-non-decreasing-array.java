class Solution {
    public boolean checkPossibility(int[] nums) {
        int prev=1;
        int moreprev=0;
        int ans=0;
        for(int i=1;i<nums.length;i++){
            int len=1;
            if(nums[i-1]<=nums[i]){
                len=Math.max(len,prev+1);
            }
            if(i==1 || nums[i-2]<=nums[i]){
                len=Math.max(len,moreprev+1);
            }
            
            moreprev=prev;
            prev=len;
            ans=Math.max(ans,prev);
            // System.out.println(nums[i]+" "+prev);
        }
        
        return ans==nums.length || ans+1==nums.length;
    }
}