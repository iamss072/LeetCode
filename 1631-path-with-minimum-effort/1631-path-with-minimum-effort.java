class Solution {
    class Pair{
        int x;
        int y;
        int w;
        public Pair(int x,int y,int w){
            this.x=x;
            this.y=y;
            this.w=w;
        }
    }
    int[][] dirs={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        
        int[][] dist=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e8;
            }
        }
        
        dist[0][0]=0;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return a.w-b.w;
        });
        
        pq.add(new Pair(0,0,0));
        
        while(pq.size()>0){
            Pair rem=pq.remove();
            int i=rem.x;
            int j=rem.y;
            
            for(int[] dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];
                
                if(ni<0 || nj<0 || ni>=n || nj>=m) continue;
                
                int md=Math.max(Math.abs(heights[ni][nj]-heights[i][j]),rem.w);
                
                if(md<dist[ni][nj]){
                    // System.out.println(i+" "+j+" "+ni+" "+nj+" "+md);
                    pq.add(new Pair(ni,nj,md));
                    dist[ni][nj]=md;
                }
            }
        }
        
        return dist[n-1][m-1];
    }
}