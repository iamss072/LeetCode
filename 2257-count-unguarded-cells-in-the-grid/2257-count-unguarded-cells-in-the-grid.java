class Solution {
    int[][] dirs={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] vis=new int[m][n];
        
        for(int[] g:guards){
            vis[g[0]][g[1]]=1;
        }
        for(int[] w:walls){
            vis[w[0]][w[1]]=2;
        }
        for(int[] g:guards){
            int tans=0;
            for(int[] dir:dirs){
                traverse(vis,dir,g[0]+dir[0],g[1]+dir[1]);
                
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    private void traverse(int[][] vis,int[] dir,int r,int c){
        
        while(r>=0 && c>=0 && r<vis.length && c<vis[0].length && (vis[r][c]==0 || vis[r][c]==-1)){

            vis[r][c]=-1;
            r=r+dir[0];
            c=c+dir[1];
        }
        
    }
}