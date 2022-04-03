class Solution {
    public int maximumCandies(int[] candies, long k) {
        long lo=1L;
        long hi=0L;
        
        for(int i:candies){
            hi=Math.max((long)i,hi);
        }
        int ans=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2L;
            
            if(ifPossible(candies,mid,k)){
                lo=mid+1;
                ans=(int)mid;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    
    private boolean ifPossible(int[] candies,long d,long k){
        long count=0L;
        for(int i:candies){
            if((long)i<d) continue;
            
            count+=((long)i)/d;
            
        }
        
        return count>=k;
    }
}