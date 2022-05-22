class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            
            int j=i;
            int k=i;
            int tans=0;
            while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
                tans++;
                j--;
                k++;
            }
            ans+=tans;
            
            j=i;
            k=i+1;
            tans=0;
            while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
                tans++;
                j--;
                k++;
            }
            ans+=tans;
        }
        return ans;
    }
}