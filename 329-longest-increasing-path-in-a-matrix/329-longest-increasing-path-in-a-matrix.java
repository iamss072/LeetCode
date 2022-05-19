class Solution {
    int[][] dirs={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int longestIncreasingPath(int[][] matrix) {
        int l=matrix.length;
        int b=matrix[0].length;
        int[][] in=new int[l][b];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                int indegree=0;
                for(int[] dir:dirs){
                    int r=i+dir[0];
                    int c=j+dir[1];
                    if(r>=0 && c>=0 && r<l && c<b && matrix[r][c]<matrix[i][j]){
                        indegree++;
                    }
                }
                in[i][j]=indegree;
                if(in[i][j]==0) q.add(i*b+j);
            }
        }
        /*for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                System.out.print(in[i][j]+" ");
            }
            System.out.println();
        }*/
        int level=0;
        while(q.size()!=0){
            //System.out.println(q);
            int size=q.size();
            for(int i=0;i<size;i++){
                int vtx=q.remove();
                int row=vtx/b;
                int col=vtx%b;
                for(int[] dir:dirs){
                    int r=row+dir[0];
                    int c=col+dir[1];
                    if(r>=0 && c>=0 && r<l && c<b && matrix[r][c]>matrix[row][col] 
                       && --in[r][c]==0){
                        q.add(r*b+c);
                    }
                }
            }
            level++;
        }
        return level;
    }
}