class Solution {
    public int numberOfWays(String s) {
        long ans=1;
        int m=1000000007;
        
        int plants=0,seats=0;
        
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S'){
                c++;
            }
        }
        
        if(c%2!=0 || c==0) return 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S'){
                if(seats==2){
                    ans=ans*(plants+1);
                    ans%=m;
                    seats=1;
                }
                else{
                    seats++;
                }
                plants=0;
            }
            else{
                plants++;
            }
            
        }
        
        return (int)ans;
    }
}