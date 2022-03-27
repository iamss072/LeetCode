class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ans=0;
        int prev=0;
        for(int i=0;i<arr.length;i++){
            int d=arr[i]-prev-1;
            
            if(d<k){
                k-=d;
            }
            else{
                return prev+k;
            }
            prev=arr[i];
        }
        return prev+k;
    }
}