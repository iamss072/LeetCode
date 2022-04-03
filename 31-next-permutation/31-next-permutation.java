class Solution {
    public void nextPermutation(int[] nums) {
        int first=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                first=i;
                break;
            }
        }
        
        if(first==-1){
            for(int i=0,j=nums.length-1;i<j;i++,j--){
                swap(nums,i,j);
            }
            return;
        }
        
        int second=-1;
        for(int i=nums.length-1;i>first;i--){
            if(nums[i]>nums[first]){
                second=i;
                break;
            }
        }
        swap(nums,first,second);
        for(int i=first+1,j=nums.length-1;i<j;i++,j--){
            swap(nums,i,j);
        }
        
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}