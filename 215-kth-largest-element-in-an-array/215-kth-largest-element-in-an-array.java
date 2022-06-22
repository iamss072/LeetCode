class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        
        int lo=0;
        int hi=nums.length-1;
        k--;
        while(lo<=hi){
            
            int idx=partition(nums,lo,hi);
            // System.out.println(idx+" "+nums[idx]);
            // for(int i=0;i<n;i++){
            //     System.out.println(nums[i]);
            // }
            if(idx==k){
                return nums[idx];
            }
            else if(idx>k){
                hi=idx-1;
            }
            else{
                lo=idx+1;
            }
            
        }
        return nums[lo];
    }
    private int partition(int[] nums,int lo,int hi){
        
        int val=nums[hi];
        
        int i=lo,j=lo;
        
        while(i<=hi){
            
            if(nums[i]>=val){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
            i++;
        }
        // System.out.println((j-1)+" "+nums[j-1]);
        return j-1;
    }
}