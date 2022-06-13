class Solution {
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        
        int[] ans=new int[(triangle.get(triangle.size()-1)).size()];
        for(int i=0; i<triangle.get(triangle.size()-1).size() ;i++)
        {
            ans[i]=triangle.get(triangle.size()-1).get(i);
        }
        /*for(int i:ans)
        {
            System.out.print(i+" ");
        }
        System.out.println();*/
        for(int i=triangle.size()-2;i>=0;i--)
        {
            
            for(int j=0;j<triangle.get(i).size();j++)
            {
                ans[j]=Math.min(ans[j],ans[j+1])+triangle.get(i).get(j);
            }
        }
        return ans[0];
    }
}