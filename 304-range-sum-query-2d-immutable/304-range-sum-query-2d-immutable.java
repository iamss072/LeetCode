class NumMatrix {
    int[][] smat;
    public NumMatrix(int[][] matrix) {
        int l=matrix.length;
        int b=matrix[0].length;
        
        smat=new int[l+1][b+1];
        
        for(int i=1;i<=l;i++){
            int rsum=0;
            for(int j=1;j<=b;j++){
                int x=i-1;
                int y=j-1;
                
                smat[i][j]=smat[x][j]+rsum+matrix[x][y];
                rsum+=matrix[x][y];
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return smat[row2+1][col2+1]-smat[row2+1][col1]-smat[row1][col2+1]+smat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */