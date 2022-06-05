class Solution {
    public int totalNQueens(int n) {
        //rowA=new boolean[n];
       coln=0;
       diag=0;
       adiag=0;
       return queencombination_03_bits(n,0,n);
    }
    int coln;
    int diag;
    int adiag;

    public int queencombination_03_bits(int n,int r,int qtp)
    {
        if(qtp==0)
        {
            return 1;
        }
        int count=0;
        for(int c=0;c<n;c++)
        {
            if((coln&(1<<c))==0 && (diag&(1<<(r+c)))==0 && (adiag & (1<<(r-c+n-1)))==0 ){
                coln^=(1<<c);
                diag^=(1<<(r+c));
                adiag^=(1<<(r-c+n-1));
            count+=queencombination_03_bits(n,r+1,qtp-1);
            coln^=(1<<c);
                diag^=(1<<(r+c));
                adiag^=(1<<(r-c+n-1));
            }
        }
        return count;
    }
}