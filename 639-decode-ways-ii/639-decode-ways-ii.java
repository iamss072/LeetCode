class Solution {
    int m=1000000007;
    public int numDecodings(String s) {
        int n=s.length();
        long[] dp=new long[n+1];
        dp[0]=1;
        if(s.charAt(0)!='0')
            dp[1]=s.charAt(0)=='*'?9L:1L;
        
        for(int i=2;i<=n;i++){
            
            if(s.charAt(i-1)=='*'){
                dp[i]=(dp[i]%m+(dp[i-1]*9L)%m)%m;
                
                if(s.charAt(i-2)=='*'){
                    dp[i]=(dp[i]%m+(dp[i-2]*15L)%m)%m;
                }
                else if(s.charAt(i-2)=='1'){
                    dp[i]=(dp[i]%m+(dp[i-2]*9L)%m)%m;
                }
                else if(s.charAt(i-2)=='2'){
                    dp[i]=(dp[i]%m+(dp[i-2]*6L)%m)%m;
                }
            }
            else{
                if(s.charAt(i-1)!='0') {
                    dp[i]=(dp[i]%m+dp[i-1]%m)%m;
                }
                if(s.charAt(i-2)=='*'){
                    dp[i]=(dp[i]%m+dp[i-2]%m)%m;
                    if(s.charAt(i-1)<='6') dp[i]=(dp[i]%m+dp[i-2]%m)%m;
                }
                else if(s.charAt(i-2)!='0'){
                    int val=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
                    if(val<=26){
                        dp[i]=(dp[i]%m+dp[i-2]%m)%m;
                    }
                }
            }
        }
        // for(int i=1;i<=n;i++){
        //     System.out.print(s.charAt(i-1)+"-"+dp[i]+" ");
        // }
        return (int)(dp[n]%m);
    }
}