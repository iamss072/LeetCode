class Solution {
    public int convertTime(String current, String correct) {
        String[] begin=current.split(":");
        String[] end=correct.split(":");
        
        int lo=Integer.parseInt(begin[0])*60+Integer.parseInt(begin[1]);
        int hi=Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
        
        int ops=0;
        
        while(lo<hi){
            // System.out.println(lo);
            int d=hi-lo;
            
            if(d/60>0){
                lo+=(d/60)*60;
                ops+=d/60;
            }
            else if(d/15>0){
                lo+=(d/15)*15;
                ops+=d/15;
            }
            else if(d/5>0){
                lo+=(d/5)*5;
                ops+=d/5;
            }
            else{
                lo+=d;
                ops+=d;
            }
        }
        // System.out.println(lo);
        return ops;
    }
}