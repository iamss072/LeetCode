class Solution {
    private void reverse(int[] arr){
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
    }
    public boolean makesquare(int[] match) {
        int[] sides=new int[4];
        int sum=0;
        for(int m:match){
            sum+=m;
        }
        int req=sum/4;
        if(req*4!=sum) return false;
        Arrays.sort(match);
        reverse(match);
        return DFS(0,req,sides,match);
    }
    
    private boolean DFS(int idx,int req,int[] sides,int[] match){
        if(idx==match.length){
            return true;
        }
        
        for(int i=0;i<4;i++){
            if(sides[i]+match[idx]>req) continue;
            sides[i]+=match[idx];
            boolean ans=DFS(idx+1,req,sides,match);
            if(ans) return ans;
            sides[i]-=match[idx];
            
        }
        return false;
    }
}