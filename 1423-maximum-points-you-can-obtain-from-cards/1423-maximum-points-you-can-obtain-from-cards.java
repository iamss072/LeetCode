class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int windowsum=0;
        for(int i=0;i<k;i++){
            windowsum+=cardPoints[i];
        }
        //System.out.println(windowsum);
        int ans=windowsum;
        
        for(int shift=1;shift<=k;shift++){
            windowsum-=cardPoints[k-shift];
            windowsum+=cardPoints[n-shift];
            //System.out.println(windowsum);
            ans=Math.max(windowsum,ans);
        }
        return ans;
    }
}