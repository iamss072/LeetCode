class Solution {
    public long numberOfWays(String s) {
        int[] zpre=new int[s.length()];
        int[] opre=new int[s.length()];
        
        for(int i=0;i<s.length();i++){
            int z=s.charAt(i)=='0'?1:0;
            int o=s.charAt(i)=='1'?1:0;
            
            if(i==0){
                zpre[i]=z;
                opre[i]=o;
            }
            else{
                zpre[i]=z+zpre[i-1];
                opre[i]=o+opre[i-1];
            }
        }
        
        // for(int i=0;i<s.length();i++){
        //     System.out.println(i+" "+zpre[i]+" "+opre[i]);
        // }
        long ans=0;
        int zr=0,or=0;
        for(int i=s.length()-1;i>=0;i--){
            long count=0;
            if(s.charAt(i)=='0'){
                count+=(long)or*(long)opre[i];
                zr++;
            }
            else{
                count+=(long)zr*(long)zpre[i];
                or++;
            }
            // System.out.println(i+" "+count);
            ans+=count;
            
        }
        return ans;
    }
}