class Solution {
     
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0)
            return "";
        boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        
        for(int l=1;l<=n;l++){
            for(int i=0,j=i+l;j<n;i++,j++){
                if(s.charAt(i)==s.charAt(j)){
                    if((j-i)==1)
                        dp[i][j]=true;
                   else
                       dp[i][j]=(dp[i][j])||(dp[i+1][j-1]);
                }                
            }            
        }
        int ans=0;
        int si=0;
        int ei=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==true)
                    if(j-i>ans)
                    {
                        si=i;
                        ei=j;
                        ans=j-i;
                    }
                //System.out.println(ans);
                
            }
        }
        //if(si>=0 && ei<n)
        return s.substring(si,ei+1);
        
    }
}