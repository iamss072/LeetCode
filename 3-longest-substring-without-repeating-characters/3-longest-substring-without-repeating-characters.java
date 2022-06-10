class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int ans=0;
        while(i<s.length()){
            char c=s.charAt(i);
            i++;
            int l=map.getOrDefault(c,j);
            while(j<l){
                j++;
            }
            // System.out.println(i+" "+j);
            ans=Math.max(ans,i-j);
            map.put(c,i);
        }
        return ans;
    }
}