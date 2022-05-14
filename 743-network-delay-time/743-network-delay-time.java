class Solution {
    public class Pair
    {
        int dest;
        int wt;
        public Pair(int dest,int wt)
        {
            this.dest=dest;
            this.wt=wt;
        }
        public String toString(){//overriding the toString() method  
                return dest+"  "+wt;  
        } 
    }
    public class In implements Comparable<In>
    {
        int src;
        int wsf;
        public In(int src,int wsf)
        {
            this.src=src;
            this.wsf=wsf;
        }
        public int compareTo(In i)
        {
            return this.wsf-i.wsf;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        List<Pair>[] graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++)
        {
            graph[i]=new ArrayList<>();
            
        }
        for(int[] arr:times)
        {
            graph[arr[0]].add(new Pair(arr[1],arr[2]));
        }
        
        PriorityQueue<In> q=new PriorityQueue<>();
        q.add(new In(K,0));
        int[] visited=new int[N+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        visited[0]=0;
        visited[K]=0;
        while(q.size()!=0)
        {
            In in=q.remove();
            
            for(Pair p:graph[in.src])
            {
                if(visited[p.dest]>in.wsf+p.wt)
                {
                    q.add(new In(p.dest,in.wsf+p.wt));
                    visited[p.dest]=in.wsf+p.wt;
                }
                
            }
        }
        int ans=0;
        for(int i=1;i<visited.length;i++)
        {
            if(visited[i]==Integer.MAX_VALUE)
                return -1;
            else
                ans=Math.max(ans,visited[i]);
        }
        return ans;
        
    }
}