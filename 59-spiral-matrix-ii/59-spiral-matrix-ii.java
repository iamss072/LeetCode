class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int top=0;
        int left=0;
        int right=n-1;
        int bottom=n-1;
        int dir=0;
        int put=1;
        while(put<=n*n)
        {
            if(dir==0)
            {
                for(int col=left;col<=right;col++)
                {
                    ans[top][col]=put;
                    put++;
                }
                top++;
            }
            else if(dir==1)
            {
                for(int row=top;row<=bottom;row++)
                {
                    ans[row][right]=put;
                    put++;
                }
                right--;
            }
            else if(dir==2)
            {
                for(int col=right;col>=left;col--)
                {
                    ans[bottom][col]=put;
                    put++;
                }
                bottom--;
            }
            else if(dir==3)
            {
                for(int row=bottom;row>=top;row--)
                {
                    ans[row][left]=put;
                    put++;
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
}