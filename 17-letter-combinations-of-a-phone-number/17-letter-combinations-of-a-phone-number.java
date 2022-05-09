class Solution {
    String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        if(digits.length()==1)
        {
            int val=digits.charAt(0)-'0';
            List<String> ans=new ArrayList<>();
            for(char ch:keys[val].toCharArray())
            {
                ans.add(ch+"");
            }
            return ans;
        }
        List<String> rans=letterCombinations(digits.substring(1));
        List<String> ans=new ArrayList<>();
        int val=digits.charAt(0)-'0';
        for(char ch:keys[val].toCharArray())
        {
            for(String s:rans)
            {
                ans.add(ch+s);
            }
        }
        return ans;
    }
}