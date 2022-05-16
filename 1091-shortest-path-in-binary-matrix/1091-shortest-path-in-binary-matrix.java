class Solution {
    int[][] dirs={
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {-1,0},
        {-1,+1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer> q=new LinkedList<>();
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        q.add(0);
        grid[0][0]=1;
        int level=1;
        while(q.size()!=0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int vtx=q.remove();
                int row=vtx/n;
                int col=vtx%n;
                if(row==n-1 && col==n-1){
                    return level;
                }
                for(int[] dir:dirs){
                    int r=row+dir[0];
                    int c=col+dir[1];
                    if(r>=0 && c>=0 && r<n && c<n && grid[r][c]==0){
                        q.add(r*n+c);
                        grid[r][c]=1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}