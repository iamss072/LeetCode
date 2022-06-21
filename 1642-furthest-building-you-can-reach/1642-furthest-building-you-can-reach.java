class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=1;i<heights.length;i++){
            int d=heights[i]-heights[i-1];
            if(d>0){
                pq.add(Math.abs(d));
            }
            if(pq.size()>ladders){
                int b=pq.remove();
                // System.out.println(b);
                bricks-=b;
            }
            if(bricks<0){
                return i-1;
            }
        }
        return heights.length-1;
    }
    
}