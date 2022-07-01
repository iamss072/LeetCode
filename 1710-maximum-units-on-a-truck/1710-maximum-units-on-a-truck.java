class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{
            return b[1]-a[1];
        });
        int i=0;
        int ans=0;
        while(i<boxTypes.length && truckSize>0){
            if(boxTypes[i][0]<=truckSize){
                ans+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else{
                ans+=boxTypes[i][1]*truckSize;
                truckSize=0;
            }
            i++;
        }
        return ans;
    }
}