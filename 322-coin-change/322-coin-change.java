class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        
        dp[0]=0;
        
        for(int i=1;i<=amount;i++)
        {
             int min=Integer.MAX_VALUE;
            for(int coin:coins)
            {
               
                int pi=i-coin;
                if(pi<0)
                {
                    continue;
                }
                if(dp[pi]==-1)
                {
                    continue;
                }
                min=Math.min(min,dp[pi]);
            }
            if(min==Integer.MAX_VALUE)
            {
                dp[i]=-1;
            }
            else
            {
                dp[i]=min+1;
            }
        }
        return dp[amount];
    }
}