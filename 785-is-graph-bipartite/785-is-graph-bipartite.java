class Solution {
    public class Pair
    {
        int src;
        int level;
        public Pair(int src,int level)
        {
            this.src=src;
            this.level=level;
        }
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<graph.length;i++)
         {
             if(!map.containsKey(i))
             {
                 boolean ans=cbp(graph,map,i);
                 if(!ans)
                     return false;
             }
         }
        return true;
    }
    public boolean cbp(int[][] graph,HashMap<Integer,Integer> map,int src)
    {
        Queue<Pair> q=new LinkedList<>();
        map.put(src,0);
        q.add(new Pair(src,0));
        
        while(q.size()!=0)
        {
            Pair p=q.remove();
            if(map.containsKey(p.src))
                {
                    if(map.get(p.src)!=p.level)
                        return false;
                    
                }
            map.put(p.src,p.level);
            for(int i:graph[p.src])
            {
                if(!map.containsKey(i))
                {
                    q.add(new Pair(i,p.level+1));
                    
                }
            }
        }
        return true;
    }
}