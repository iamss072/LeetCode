class Solution {
    class Pair{
        char c;
        int count;
        public Pair(char c,int count){
            this.c=c;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.empty() || st.peek().c!=ch){
                st.push(new Pair(ch,1));
            }
            else{
                Pair p=st.pop();
                p.count++;
                st.push(p);
            }
            if(st.peek().count==k){
                st.pop();
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(!st.empty()){
            Pair p=st.pop();
            for(int i=0;i<p.count;i++)
                sb.append(p.c);
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}