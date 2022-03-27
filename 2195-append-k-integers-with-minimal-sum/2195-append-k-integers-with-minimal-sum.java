class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        // for(int i:nums){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        long ans=0;
        int prev=0;
        for(int i=0;i<nums.length;i++){
            int d=nums[i]-prev-1;
            
            if(d<=0) {
                prev=nums[i];
                continue;
            }
            
            if(d<=k){
                long n=(long)d;
                long start=(long)(prev+1);
                long end=(long)(nums[i]-1);
                long sum=(n*(start+end))/2L;
                ans+=sum;
                k-=d;
                // System.out.println(prev+" "+nums[i]+" "+start+" "+end);
            }
            else{
                long n=(long)k;
                long start=(long)(prev+1);
                long end=(long)(prev+k);
                long sum=(n*(start+end))/2L;
                ans+=sum;
                k=0;
                // System.out.println(prev+" "+nums[i]+" "+start+" "+end);
            }
            
            prev=nums[i];
            if(k==0) break;
        }
        if(k>0){
            long n=(long)k;
            long start=(long)(prev+1);
            long end=(long)(prev+k);
            long sum=(n*(start+end))/2L;
            ans+=sum;
            k=0;
        }
        return ans;
    }
}