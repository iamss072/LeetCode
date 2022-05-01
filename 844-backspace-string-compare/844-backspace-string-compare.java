class Solution {
    public boolean backspaceCompare(String s, String t) {
        int acount=0;
        int bcount=0;
        
        int i=s.length()-1,j=t.length()-1;
        
        while(i>=0 || j>=0){
            // System.out.println(i+" "+j);
            while(i>=0 && s.charAt(i)=='#'){
                acount++;
                i--;
            }
            while(j>=0 && t.charAt(j)=='#'){
                bcount++;
                j--;
            }
            if(acount>0 && bcount>0){
                i--;
                j--;
                acount--;
                bcount--;
            }else if(acount>0){
                i--;
                acount--;
            }
            else if(bcount>0){
                j--;
                bcount--;
            }
            else{
                if(i>=0 && j>=0){
                    if(s.charAt(i)==t.charAt(j)){
                        i--;
                        j--;
                    }
                    else return false;
                }
                else if(i>=0 && j<0){
                    if(acount>0){
                        acount--;
                        i--;
                    }
                    else{
                        return false;
                    }
                }
                else if(j>=0 && i<0){
                    if(bcount>0){
                        bcount--;
                        j--;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}