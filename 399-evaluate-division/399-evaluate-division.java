class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> parents=new HashMap<>();
        
        for(int i=0;i<values.length;i++){
            List<String> al=equations.get(i);
            double val=values[i];
            
            double v2=(double)1.0000/val;
            if(!parents.containsKey(al.get(1))){
                parents.put(al.get(1),new HashMap<>());
            }
            parents.get(al.get(1)).put(al.get(0),val);
            
            if(!parents.containsKey(al.get(0))){
                parents.put(al.get(0),new HashMap<>());
            }
            parents.get(al.get(0)).put(al.get(1),v2);
        }
        // System.out.println(parents);
        double[] ans=new double[queries.size()];
        Arrays.fill(ans,-1.00000);
        int idx=0;
        for(List<String> q:queries){
            String s1=q.get(0);
            String s2=q.get(1);
            HashSet<String> vis=new HashSet<>();
            double tans=dfs(s1,s2,parents,vis);
            ans[idx++]=tans;
        }
        return ans;
        
    }
    private double dfs(String src,String tar,
                       HashMap<String,HashMap<String,Double>> parents,HashSet<String> vis){
        // if(parents.containsKey(tar) && parents.get(tar).containsKey(src)){
        //     double v=parents.get(tar).get(src);
        //     return 1.00000/v;
        // }
        if(!parents.containsKey(src)){
            // System.out.println("no");
            return -1.00000;
        }
        if(src.equals(tar)){
            // System.out.println("yes");
            return 1.00000;
        }
        vis.add(src);
        HashMap<String,Double> map=parents.get(src);
        // System.out.println(src+" "+tar);
        
            for(String t:map.keySet()){
                if(vis.contains(t)) continue;
                double tans=dfs(t,tar,parents,vis);
                if(tans!=-1.00000){
                    // System.out.println(map.get(t));
                    return tans/map.get(t);
                }
            }
        vis.remove(src);
        return -1.00000;
    }
}