class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n=piles.size();
        
        return find(piles,k,0,new Integer[n][k+1]);
    }
    private int find(List<List<Integer>> piles,int k,int idx,Integer[][] dp){
        
        if(k==0 || idx==piles.size()) return 0;
        
        if(dp[idx][k]!=null) return dp[idx][k];
        int ans=find(piles,k,idx+1,dp);
        int pick=0;
        for(int p=0;p<k;p++){
            
            if(p==piles.get(idx).size()) break;
            
            pick+=piles.get(idx).get(p);
            
            int tans=pick+find(piles,k-p-1,idx+1,dp);
            ans=Math.max(ans,tans);
        }
        
        return dp[idx][k]=ans;
    }
}