class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int s1=pq.remove();
            int s2=pq.remove();
                        //System.out.println(s1+" "+s2);
            if(s1==s2) continue;
            s1-=s2;
            pq.add(s1);
        }
        if(pq.size()==0) return 0;
        return pq.remove();
    }
}