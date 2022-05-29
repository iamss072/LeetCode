class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                int v=words[i].charAt(j)-'a';
                dp[i]|=(1<<v);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if( (dp[i]&dp[j])==0 &&  words[i].length()*words[j].length()>ans){
                    ans=words[i].length()*words[j].length();
                }
            }
        }
        return ans;
    }
}