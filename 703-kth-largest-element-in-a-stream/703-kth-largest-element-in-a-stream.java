class KthLargest {
    PriorityQueue<Integer> pq;
    int up;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        up=k;
        for(int v:nums){
            pq.add(v);
            if(pq.size()>k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>up){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */