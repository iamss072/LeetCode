class Solution {
    int[][] dirs={
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {-1,0},
        {-1,1}
    };
    public void gameOfLife(int[][] board) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count=update(board,i,j);
                
                if((board[i][j]&1)==1){
                    if(count<2 || count>3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=3;
                    }
                }
                else{
                    if(count==3){
                        board[i][j]=2;
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=(board[i][j]>>1);
            }
        }
        
    }
    private int update(int[][] board,int r,int c){
        
        int count=0;
        
        for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
            
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length){
                count+=(board[nr][nc]&1);
            }
        }
        
        return count;
    }
}