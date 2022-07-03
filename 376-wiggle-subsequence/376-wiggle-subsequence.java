class Solution {
    class Pair
    {
        int len;
        char ch;
        public Pair(){}
        public Pair(int len,char ch)
        {
            this.len=len;
            this.ch=ch;
        }
    }
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==0)
            return n;
        Pair[] dp=new Pair[n];
        dp[0]=new Pair(1,'o');
        int ans=1;
        for(int i=1;i<n;i++)
        {
            Pair p=new Pair();
            int ml=0;
            for(int j=0;j<i;j++)
            {
                if(nums[i]-nums[j]>0)
                {
                    if(dp[j].ch=='o' || dp[j].ch=='n')
                    {
                        if(dp[j].len>ml)
                        {
                            p.ch='p';
                            p.len=dp[j].len+1;
                            ml=dp[j].len;
                        }
                    }
                }
                else if(nums[i]-nums[j]<0)
                {
                    if(dp[j].ch=='o' || dp[j].ch=='p')
                    {
                        if(dp[j].len>ml)
                        {
                            p.ch='n';
                            p.len=dp[j].len+1;
                            ml=dp[j].len;
                        }
                    }
                }
                else
                {
                    p.ch='o';
                    p.len=1;
                }
                
            }
            dp[i]=p;
                ans=Math.max(ans,dp[i].len);
        }
        return ans;
    }
}