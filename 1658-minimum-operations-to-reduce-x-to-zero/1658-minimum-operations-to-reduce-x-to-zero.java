class Solution {
    public int minOperations(int[] nums, int X) {
        int idx=0;
        int count=0;
        int n=nums.length;
        while(idx<nums.length && count<X) {
            count+=nums[idx++];
        }
        if(count<X) return -1;
        int ans=count==X?idx:(int)1e8;
        int shift=1;
        while(true){
            while(idx>0 && count>=X){
                if(count==X) ans=Math.min(ans,idx+shift-1);
                count-=nums[--idx];
            }
            
            while(count<X){
                count+=nums[n-shift++];
            }
            if(count==X) ans=Math.min(ans,idx+shift-1);
            if(idx==0) break;
        }
        return ans==(int)1e8?-1:ans;
    }
}