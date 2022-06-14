class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return find(word1,word2,0,0,dp);
    }
    public int find(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=(int)1e8;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=find(s1,s2,i+1,j+1,dp);
        }
        else{
            int tans1=find(s1,s2,i+1,j,dp);
            int tans2=find(s1,s2,i,j+1,dp);
            ans=Math.min(tans1,tans2)+1;
        }
        return dp[i][j]=ans;
    }
}