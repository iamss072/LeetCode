class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        
        long[] pre=new long[n+1];
        
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+(long)nums[i-1];
        }
        
        int ans=(int)1e8;
        int ret=-1;
        for(int i=1;i<=n;i++){
            int left=(int)(pre[i]/(long)i);
            
            int right=i!=n?(int)((pre[n]-pre[i])/(long)(n-i)):0;
            
            if(Math.abs(left-right)<ans){
                ans=Math.abs(left-right);
                ret=i-1;
            }
        }
        
        return ret;
    }
}