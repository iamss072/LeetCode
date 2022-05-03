class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int min=(int)1e8;
        int max=-(int)1e8;
        int m1=-1;
        for(int i=0;i<n;i++){
            if(nums[i]<max) m1=i;
            max=Math.max(max,nums[i]);
        }
        int m2=-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]>min) m2=i;
            min=Math.min(min,nums[i]);
        }
        if(m1==m2) return 0;
        return m1-m2+1;
    }
}