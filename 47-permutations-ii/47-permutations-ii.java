class Solution {
    List<Integer> sans;
    List<List<Integer>> ans;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        sans=new ArrayList<>();
        ans=new ArrayList<>();
        used=new boolean[nums.length];
        Arrays.sort(nums);
        finder(nums);
        return ans;
    }
    public void finder(int[] nums)
    {
        if(sans.size()==nums.length)
        {
            ans.add(new ArrayList<>(sans));
            return;
        }
        int prev=-(int)1e8;
        for(int i=0;i<nums.length;i++)
        {
            if(!used[i] && nums[i]!=prev)
            {
                sans.add(nums[i]);
                used[i]=true;
                finder(nums);
                sans.remove(sans.size()-1);
                used[i]=false;
                prev=nums[i];
            }
        }
    }
}