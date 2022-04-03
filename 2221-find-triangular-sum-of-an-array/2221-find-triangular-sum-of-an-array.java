class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        
        for(int i:nums){
            ans.add(i);
        }
        
        while(ans.size()>1){
            List<Integer> tans=new ArrayList<>();
            for(int i=0;i<ans.size()-1;i++){
                int v=(ans.get(i)+ans.get(i+1))%10;
                tans.add(v);
            }
            ans=tans;
        }
        
        return ans.get(0);
    }
}