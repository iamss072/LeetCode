class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int[] a:matches){
            map.put(a[1],map.getOrDefault(a[1],0)+1);
        }
        
        List<Integer> l1=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int[] a:matches){
            if(!map.containsKey(a[0])){
                if(set.contains(a[0]))
                    continue;
                l1.add(a[0]);
                set.add(a[0]);
            }
        }
        Collections.sort(l1);
        
        List<Integer> l2=new ArrayList<>();
        for(int k:map.keySet()){
            if(map.get(k)==1){
                l2.add(k);
            }
        }
        Collections.sort(l2);
        
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        
        return ans;
    }
}