class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        st.push(-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')' && st.peek()!=-1 && s.charAt(st.peek())=='('){
                st.pop();
                ans=Math.max(ans,i-st.peek());
            } else{
                st.push(i);
            }
        }
        return ans;
    }
}