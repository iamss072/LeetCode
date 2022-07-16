class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Integer[][][] dp=new Integer[m][n][maxMove+1];
        int ans=solve(startRow,startColumn,maxMove,dp);
        return ans;
    }
    int[][] dirs={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    int mod=1000000007;
    private int solve(int r,int c,int rm,Integer[][][] dp){
        if(rm<0){
            return 0;
        }
        if(r<0 || c<0 || r>=dp.length || c>=dp[0].length){
            return 1;
        }
        if(dp[r][c][rm]!=null) return dp[r][c][rm];
        int ans=0;
        for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
            
            int tans=solve(nr,nc,rm-1,dp);
            ans=(ans%mod+tans%mod)%mod;
        }
        return dp[r][c][rm]=ans;
    }
}