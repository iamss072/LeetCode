class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][5];
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<5;j++){
                if(i==1) dp[i][j]=1;
                else if(j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        int ans=0;
        for(int i=0;i<5;i++){
            ans+=dp[n][i];
        }
        return ans;
    }
    
}