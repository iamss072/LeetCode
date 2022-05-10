class Solution {
    List<Integer> sans;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n==0 || k==0)
            return new ArrayList<>();
        sans=new ArrayList<>();
        ans=new ArrayList<>();
        helper(1,n,k,0);
        return ans;
    }
    public void helper(int idx,int n,int k,int ssf)
    {
        if(ssf>n || sans.size()>k)
            return;
        if(ssf==n && sans.size()==k)
        {
            ans.add(new ArrayList<>(sans));
            return;
        }
        for(int i=idx;i<=9;i++)
        {
            sans.add(i);
            helper(i+1,n,k,ssf+i);
            sans.remove(sans.size()-1);
        }
    }
}