class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if(nums.length==0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int i=0;
        int j=0;
        int csum=nums[0];
        map.put(nums[0],0);
        int ans=csum;
        while(++j<nums.length){
            int num=nums[j];
            if(map.containsKey(num) && map.get(num)>=i){
                while(nums[i]!=num){
                    csum-=nums[i];
                    i++;
                }
                csum-=nums[i];
                i++;
            }
            csum+=nums[j];
            ans=Math.max(csum,ans);
            map.put(num,j);
        }
        return ans;
    }
}