class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long mGH=0;
        long mGV=0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for(int i=0;i<horizontalCuts.length;i++){
            if(i==0){
                mGH=Math.max(mGH,horizontalCuts[i]);
            }
            else{
                mGH=Math.max(mGH,horizontalCuts[i]-horizontalCuts[i-1]);
            }
        }
        if(horizontalCuts.length>0) 
            mGH=Math.max(mGH,h-horizontalCuts[horizontalCuts.length-1]);
        else 
            mGH=h;
        
        for(int i=0;i<verticalCuts.length;i++){
            if(i==0){
                mGV=Math.max(mGV,verticalCuts[i]);
            }
            else{
                mGV=Math.max(mGV,verticalCuts[i]-verticalCuts[i-1]);
            }
        }
        if(verticalCuts.length>0)
            mGV=Math.max(mGV,w-verticalCuts[verticalCuts.length-1]);
        else 
            mGV=w;
        // System.out.println(mGH+" "+mGV);
        long ans=(long)(mGH*mGV);
        
        int ret=(int)(ans%1000000007);
        
        return ret;
    }
}