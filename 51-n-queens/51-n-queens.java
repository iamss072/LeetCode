class Solution {
    int col=0,diag=0,adiag=0;
    public List<List<String>> solveNQueens(int n) {
        char[][] ans=new char[n][n];
        for(char[] arr:ans) Arrays.fill(arr,'.');
        List<List<String>> pans=new ArrayList<>();
        find(0,n,pans,ans);
        return pans;
    }
    private void find(int r,int n,List<List<String>> pans,char[][] ans){
        if(r==n){
            
            List<String> tans=new ArrayList<>();
            for(char[] arr:ans){
                tans.add(String.valueOf(arr));
            }
            pans.add(tans);
            return;
        }
        
        for(int c=0;c<n;c++){
            int diagn=r+c;
            int adiagn=n-(r-c);
            
            int cmask=(1<<c);
            int dmask=(1<<diagn);
            int admask=(1<<adiagn);
            
            if( (cmask&col)==0 && (dmask&diag)==0 && (admask&adiag)==0 ){
                col^=cmask;
                diag^=dmask;
                adiag^=admask;
                
                ans[r][c]='Q';
                
                find(r+1,n,pans,ans);
                
                ans[r][c]='.';
                
                col^=cmask;
                diag^=dmask;
                adiag^=admask;
            }
            
        }
    }
}