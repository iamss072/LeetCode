class Solution {
    public int splitArray(int[] nums, int m) {
        int lo=0,hi=0;
        
        for(int i:nums){
            lo=Math.max(lo,i);
            hi+=i;
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            int count=find(nums,mid,m);
            // System.out.println(lo+" "+hi+" "+mid+" "+count);
            if(count<=m){
                // System.out.println(count+" "+m);
                hi=mid-1;
                ans=Math.min(ans,mid);
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    
    private int find(int[] nums,int s,int m){
        int ans=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=s){
                sum+=nums[i];
            }
            else{
                sum=0;
                sum+=nums[i];
                ans++;
            }
        }
        return ans+1;
    }
}