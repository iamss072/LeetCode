class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[] arr=new int[n*m];
        
        k%=m*n;
        
        for(int i=0,idx=0;i<m;i++){
            for(int j=0;j<n;j++,idx++){
                arr[idx]=grid[i][j];
            }
        }
        
        
        rotate(arr,k);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0,idx=0;i<m;i++){
            List<Integer> tans=new ArrayList<>();
            for(int j=0;j<n;j++,idx++){
                tans.add(arr[idx]);
            }
            ans.add(tans);
        }
        
        return ans;
    }
    
    private void rotate(int[] arr,int k){
        
        reverse(0,arr.length-k-1,arr);
        // display(arr);
        reverse(arr.length-k,arr.length-1,arr);
        // display(arr);
        reverse(0,arr.length-1,arr);
        // display(arr);
    }
    private void display(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    private void reverse(int lo,int hi,int[] arr){
        
        while(lo<hi){
            int temp=arr[lo];
            arr[lo]=arr[hi];
            arr[hi]=temp;
            lo++;
            hi--;
        }
    }
}