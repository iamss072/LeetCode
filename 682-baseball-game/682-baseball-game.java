class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st=new Stack<>();
        
        for(String s:ops){
            if(s.equals("+")){
                int v1=st.pop();
                int v2=st.pop();
                
                int v=v1+v2;
                
                st.push(v2);
                st.push(v1);
                st.push(v);
            }
            else if(s.equals("D")){
                st.push(2*st.peek());
            }
            else if(s.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        int ans=0;
        while(!st.empty()){
            ans+=st.pop();
        }
        return ans;
    }
}