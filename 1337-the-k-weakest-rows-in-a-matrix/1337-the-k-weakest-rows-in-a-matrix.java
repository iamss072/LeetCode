class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n=mat.length;
        int[][] ans=new int[n][2];
        
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
            ans[i][0]=sum;
            ans[i][1]=i;
        }
        Arrays.sort(ans,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        int[] ret=new int[k];
        for(int i=0;i<k;i++){
            ret[i]=ans[i][1];
        }
        return ret;
    }
}