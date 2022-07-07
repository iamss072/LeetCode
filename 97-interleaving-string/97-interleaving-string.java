class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int l=s1.length();
        int b=s2.length();
        int[][] dp=new int[l+1][b+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int ans=find(0,0,0,s1,s2,s3,dp);
        return ans==1;
    }
    private int find(int i,int j,int idx,String s1,String s2,String s3,int[][] dp){
        if(idx==s3.length()) return dp[i][j]=1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i<s1.length() && j<s2.length() &&
           s1.charAt(i)==s3.charAt(idx) && s2.charAt(j)==s3.charAt(idx)){
            int tans1=find(i+1,j,idx+1,s1,s2,s3,dp);
            if(tans1==1) return dp[i][j]=1;
            int tans2=find(i,j+1,idx+1,s1,s2,s3,dp);
            return dp[i][j]=tans2;
        }
        else if(i<s1.length() && s1.charAt(i)==s3.charAt(idx)){
            return dp[i][j]=find(i+1,j,idx+1,s1,s2,s3,dp);
        }
        else if(j<s2.length() && s2.charAt(j)==s3.charAt(idx)){
            return dp[i][j]=find(i,j+1,idx+1,s1,s2,s3,dp);
        }
        else{
            return dp[i][j]=0;
        }
    }
}