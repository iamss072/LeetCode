class Solution {
    int[][] dirs={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) return 0;
        //boolean[][] visited=new boolean[grid.length][grid[0].length];
        int mar=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1 && grid[i][j]!=0){
                    mar=Math.max(mar,check(i,j,grid));
                }
            }
        }
        return mar;
    }
    private int check(int row,int col,int[][] grid){
        grid[row][col]=-1;
        int count=1;
        for(int[] dir:dirs){
            int r=row+dir[0];
            int c=col+dir[1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]!=0 && 
               grid[r][c]!=-1)
                count+=check(r,c,grid);
        }
        return count;
    }
}