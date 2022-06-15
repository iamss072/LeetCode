class Solution {
    private boolean isMatch(String s,String p){
        int i=0;
        int j=0;
        while(i<s.length() && s.charAt(i)==p.charAt(j)){
            i++;
            j++;
        }
        j++;
        while(i<s.length() && s.charAt(i)==p.charAt(j)){
            i++;
            j++;
        }
        return i==s.length()&&j==p.length();
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int[] dp=new int[words.length];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<words.length;i++){
            int tans=0;
            for(int j=0;j<i;j++){
                if(words[i].length()==words[j].length()+1){
                    boolean t=isMatch(words[j],words[i]);
                    if(t) tans=Math.max(tans,dp[j]);
                    // System.out.println(words[j]+" "+words[i]+" "+t);
                }
            }
            
            dp[i]=tans+1;
            
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    
}