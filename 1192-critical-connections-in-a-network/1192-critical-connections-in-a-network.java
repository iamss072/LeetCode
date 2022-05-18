class Solution {
    boolean[] vis;
    int[] dis;
    int[] low;
    int time=0;
    List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(List<Integer> con:connections){
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        
        vis=new boolean[n];
        dis=new int[n];
        low=new int[n];
        ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(-1,i,graph);
            }
        }
        return ans;
    }
    private void dfs(int par,int src,List<Integer>[] graph){
        dis[src] = low[src] = time++;
        vis[src] = true;
        for(int nbr:graph[src]){
            if(!vis[nbr]){
                dfs(src,nbr,graph);
                if(dis[src]<low[nbr]){
                    List<Integer> tans=new ArrayList<>();
                    // System.out.println()
                    tans.add(src);
                    tans.add(nbr);
                    ans.add(tans);
                }
                low[src]=Math.min(low[nbr],low[src]);
            }
            else if(nbr!=par){
                low[src]=Math.min(low[src],dis[nbr]);
            }
        }
    }
}