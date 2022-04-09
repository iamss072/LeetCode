class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[0]-a[0];
        });
        for(Map.Entry me:map.entrySet()){
            int[] tans=new int[2];
            tans[0]=(int)me.getValue();
            tans[1]=(int)me.getKey();
            pq.add(tans);
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove()[1];
        }
        return ans;
    }
}