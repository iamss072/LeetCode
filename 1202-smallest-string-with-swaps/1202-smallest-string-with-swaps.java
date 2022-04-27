class Solution {
    private int findParent(int[] parent,int u){
        if(u==parent[u]) return u;
        return parent[u]=findParent(parent,parent[u]);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(List<Integer> pair:pairs){
            int a=pair.get(0);
            int b=pair.get(1);
            
            int p1=findParent(parent,a);
            int p2=findParent(parent,b);
            
            if(p1==p2) continue;
            
            parent[p1]=p2;
            
        }
        HashMap<Integer,List<Character>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int p=findParent(parent,i);
            if(!map.containsKey(p)) map.put(p,new LinkedList<>());
            
            map.get(p).add(s.charAt(i));
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(Integer i:map.keySet()){
            List<Character> ll=map.get(i);
            Collections.sort(ll);
        }
        
        for(int i=0;i<n;i++){
            int p=findParent(parent,i);
            List<Character> ll=map.get(p);
            
            sb.append(ll.remove(0));
            
        }
        
        return sb.toString();
    }
}